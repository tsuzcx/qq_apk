package com.tencent.mobileqq.now.recommend;

import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RcmdAnchor;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RecommendItem;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RecommendPageReq;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RecommendPageRsp;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RoomRichTitle;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.UserExtraInfo;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.UserMsgInfo;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.UserTag;
import com.tencent.mobileqq.now.netchannel.websso.ChannelCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;

public class RecommendAnchorDataManager
{
  private static int k;
  public final int a = 2;
  protected boolean b = false;
  private final String c = RecommendAnchorDataManager.class.getSimpleName();
  private final String d = "78711";
  private Set<String> e = new HashSet();
  private int f = 0;
  private int g = 0;
  private final int h = 60000;
  private long i = 0L;
  private int j = 0;
  private volatile boolean l = false;
  private final List<RecommendAnchorInfo> m = new CopyOnWriteArrayList();
  
  private RecommendAnchorInfo a(NowQQLiveHomepageProto.RcmdAnchor paramRcmdAnchor)
  {
    RecommendAnchorInfo localRecommendAnchorInfo = new RecommendAnchorInfo();
    localRecommendAnchorInfo.q = paramRcmdAnchor.string_head_img_url.get();
    localRecommendAnchorInfo.d = paramRcmdAnchor.string_room_img_url.get();
    localRecommendAnchorInfo.c = paramRcmdAnchor.hall_room_id.get();
    localRecommendAnchorInfo.e = paramRcmdAnchor.string_name.get();
    localRecommendAnchorInfo.i = paramRcmdAnchor.uint32_watch_count.get();
    localRecommendAnchorInfo.f = paramRcmdAnchor.string_location.get();
    localRecommendAnchorInfo.h = paramRcmdAnchor.string_id.get();
    localRecommendAnchorInfo.r = paramRcmdAnchor.imsdk_tiny_id.get();
    localRecommendAnchorInfo.x = paramRcmdAnchor.rtmp_url.get();
    int n = paramRcmdAnchor.allow_play.get();
    boolean bool2 = true;
    boolean bool1;
    if (n == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localRecommendAnchorInfo.z = bool1;
    if (paramRcmdAnchor.video_preview.get() == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localRecommendAnchorInfo.B = bool1;
    localRecommendAnchorInfo.k = paramRcmdAnchor.microphone_flag.get();
    localRecommendAnchorInfo.l = paramRcmdAnchor.icon_url.get();
    localRecommendAnchorInfo.m = paramRcmdAnchor.rich_title.elements.get();
    localRecommendAnchorInfo.p = paramRcmdAnchor.string_description.get();
    localRecommendAnchorInfo.o = paramRcmdAnchor.award_pendant_url.get();
    if (paramRcmdAnchor.extra_info.has())
    {
      NowQQLiveHomepageProto.UserExtraInfo localUserExtraInfo = (NowQQLiveHomepageProto.UserExtraInfo)paramRcmdAnchor.extra_info.get();
      if ((localUserExtraInfo.medal_info_list.has()) && (localUserExtraInfo.medal_info_list.get() != null) && (localUserExtraInfo.medal_info_list.size() > 0)) {
        localRecommendAnchorInfo.a(localUserExtraInfo.medal_info_list.get());
      }
    }
    localRecommendAnchorInfo.s = paramRcmdAnchor.user_tag.color.get();
    try
    {
      if (!TextUtils.isEmpty(paramRcmdAnchor.user_tag.change_color.get())) {
        localRecommendAnchorInfo.t = Integer.parseInt(paramRcmdAnchor.user_tag.change_color.get(), 16);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.e(this.c, 2, localNumberFormatException, new Object[0]);
    }
    localRecommendAnchorInfo.u = paramRcmdAnchor.user_tag.pic_url.get();
    localRecommendAnchorInfo.v = paramRcmdAnchor.user_tag.wording.get();
    localRecommendAnchorInfo.g = paramRcmdAnchor.string_jump_url.get();
    localRecommendAnchorInfo.w = paramRcmdAnchor.user_tag.type.get();
    localRecommendAnchorInfo.y = paramRcmdAnchor.advertising_sign.get();
    return localRecommendAnchorInfo;
  }
  
  public int a(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return -1;
    }
    QLog.d(this.c, 2, "parse data");
    if (paramInt <= 0)
    {
      this.e.clear();
      this.m.clear();
      this.f = 0;
      QLog.d(this.c, 2, "clear state");
    }
    try
    {
      NowQQLiveHomepageProto.RecommendPageRsp localRecommendPageRsp = new NowQQLiveHomepageProto.RecommendPageRsp();
      localRecommendPageRsp.mergeFrom(paramArrayOfByte);
      this.g = localRecommendPageRsp.uint32_new_timestamp.get();
      k = localRecommendPageRsp.rcmd_col_mode.get();
      paramArrayOfByte = localRecommendPageRsp.rpt_msg_rcmd.get().iterator();
      while (paramArrayOfByte.hasNext())
      {
        localObject1 = (NowQQLiveHomepageProto.RecommendItem)paramArrayOfByte.next();
        Object localObject2;
        Object localObject3;
        if (this.e.contains(((NowQQLiveHomepageProto.RecommendItem)localObject1).string_key.get()))
        {
          localObject2 = this.c;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("去重： ");
          ((StringBuilder)localObject3).append(((NowQQLiveHomepageProto.RecommendItem)localObject1).string_key.get());
          QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
        }
        else
        {
          this.e.add(((NowQQLiveHomepageProto.RecommendItem)localObject1).string_key.get());
          int n = ((NowQQLiveHomepageProto.RecommendItem)localObject1).uint32_type.get();
          if (n != 0)
          {
            if (n == 5)
            {
              localObject3 = (NowQQLiveHomepageProto.RcmdAnchor)((NowQQLiveHomepageProto.RecommendItem)localObject1).msg_anchor.get();
              localObject2 = ((NowQQLiveHomepageProto.RcmdAnchor)localObject3).string_id.get();
              if ((localObject2 != null) && (((String)localObject2).equals(BaseApplicationImpl.getApplication().getRuntime().getAccount())))
              {
                QLog.d(this.c, 2, "主页过滤自己");
              }
              else
              {
                localObject2 = a((NowQQLiveHomepageProto.RcmdAnchor)localObject3);
                ((RecommendAnchorInfo)localObject2).a = ((NowQQLiveHomepageProto.RecommendItem)localObject1).string_key.get();
                n = this.f;
                this.f = (n + 1);
                ((RecommendAnchorInfo)localObject2).b = n;
                ((RecommendAnchorInfo)localObject2).A = ((NowQQLiveHomepageProto.RcmdAnchor)localObject3).union_channel_sign.get();
                localObject1 = this.c;
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("NewRcmdDataMgr, parseData()  Double----anchor_union_channel_sign = ");
                ((StringBuilder)localObject3).append(((RecommendAnchorInfo)localObject2).A);
                QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
                this.m.add(localObject2);
              }
            }
          }
          else
          {
            localObject2 = (NowQQLiveHomepageProto.RcmdAnchor)((NowQQLiveHomepageProto.RecommendItem)localObject1).msg_anchor.get();
            localObject3 = ((NowQQLiveHomepageProto.RcmdAnchor)localObject2).string_id.get();
            if ((localObject3 != null) && (((String)localObject3).equals(BaseApplicationImpl.getApplication().getRuntime().getAccount())))
            {
              QLog.d(this.c, 2, "主页过滤自己");
            }
            else
            {
              localObject3 = a((NowQQLiveHomepageProto.RcmdAnchor)localObject2);
              ((RecommendAnchorInfo)localObject3).a = ((NowQQLiveHomepageProto.RecommendItem)localObject1).string_key.get();
              n = this.f;
              this.f = (n + 1);
              ((RecommendAnchorInfo)localObject3).b = n;
              ((RecommendAnchorInfo)localObject3).A = ((NowQQLiveHomepageProto.RcmdAnchor)localObject2).union_channel_sign.get();
              this.m.add(localObject3);
            }
          }
        }
      }
      paramArrayOfByte = this.c;
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("第");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("开始拉取:");
      ((StringBuilder)localObject1).append(localRecommendPageRsp.rpt_msg_rcmd.get().size());
      ((StringBuilder)localObject1).append("个数据;");
      ((StringBuilder)localObject1).append(this.m.size());
      ((StringBuilder)localObject1).append("行");
      QLog.d(paramArrayOfByte, 2, ((StringBuilder)localObject1).toString());
      return -1;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return -1;
  }
  
  public List<RecommendAnchorInfo> a()
  {
    return this.m;
  }
  
  public void a(int paramInt, RecommendAnchorDataManager.RecommendAnchorDataCallback paramRecommendAnchorDataCallback, boolean paramBoolean)
  {
    if (this.l) {
      return;
    }
    if (paramBoolean)
    {
      this.j += 1;
      if (this.j >= 3)
      {
        paramRecommendAnchorDataCallback.b();
        return;
      }
    }
    this.l = true;
    NowQQLiveHomepageProto.RecommendPageReq localRecommendPageReq = new NowQQLiveHomepageProto.RecommendPageReq();
    if (TextUtils.isEmpty(BaseApplicationImpl.getApplication().getRuntime().getAccount())) {
      return;
    }
    localRecommendPageReq.uint32_last_update.set(this.g);
    localRecommendPageReq.uint32_index.set(paramInt);
    NowQQLiveHomepageProto.UserMsgInfo localUserMsgInfo = new NowQQLiveHomepageProto.UserMsgInfo();
    localUserMsgInfo.type.set(1);
    localUserMsgInfo.desc.set(String.valueOf(2));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localUserMsgInfo);
    localRecommendPageReq.user_msg_info.set(localArrayList);
    localRecommendPageReq.channel.set("78711");
    localRecommendPageReq.rcmd_col_mode.set(k);
    localRecommendPageReq.device_id.set(MobileInfoUtil.getImei());
    localRecommendPageReq.qimei.set(UserAction.getQIMEI());
    ChannelCenter.b().a(1718, 100, localRecommendPageReq.toByteArray(), new RecommendAnchorDataManager.1(this, paramInt, paramRecommendAnchorDataCallback));
  }
  
  public void a(RecommendAnchorDataManager.RecommendAnchorDataCallback paramRecommendAnchorDataCallback)
  {
    if (System.currentTimeMillis() > this.i + 60000L) {
      a(0, paramRecommendAnchorDataCallback, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.recommend.RecommendAnchorDataManager
 * JD-Core Version:    0.7.0.1
 */