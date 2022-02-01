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
  private static int f;
  public final int a;
  private long jdField_a_of_type_Long = 0L;
  private final String jdField_a_of_type_JavaLangString = RecommendAnchorDataManager.class.getSimpleName();
  private final List<RecommendAnchorInfo> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  protected boolean a;
  private int jdField_b_of_type_Int = 0;
  private final String jdField_b_of_type_JavaLangString = "78711";
  private volatile boolean jdField_b_of_type_Boolean = false;
  private int c;
  private final int d;
  private int e;
  
  public RecommendAnchorDataManager()
  {
    this.jdField_a_of_type_Int = 2;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 60000;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private RecommendAnchorInfo a(NowQQLiveHomepageProto.RcmdAnchor paramRcmdAnchor)
  {
    RecommendAnchorInfo localRecommendAnchorInfo = new RecommendAnchorInfo();
    localRecommendAnchorInfo.j = paramRcmdAnchor.string_head_img_url.get();
    localRecommendAnchorInfo.jdField_b_of_type_JavaLangString = paramRcmdAnchor.string_room_img_url.get();
    localRecommendAnchorInfo.jdField_b_of_type_Int = paramRcmdAnchor.hall_room_id.get();
    localRecommendAnchorInfo.jdField_c_of_type_JavaLangString = paramRcmdAnchor.string_name.get();
    localRecommendAnchorInfo.jdField_c_of_type_Int = paramRcmdAnchor.uint32_watch_count.get();
    localRecommendAnchorInfo.jdField_d_of_type_JavaLangString = paramRcmdAnchor.string_location.get();
    localRecommendAnchorInfo.jdField_f_of_type_JavaLangString = paramRcmdAnchor.string_id.get();
    localRecommendAnchorInfo.jdField_a_of_type_Long = paramRcmdAnchor.imsdk_tiny_id.get();
    localRecommendAnchorInfo.m = paramRcmdAnchor.rtmp_url.get();
    int i = paramRcmdAnchor.allow_play.get();
    boolean bool2 = true;
    boolean bool1;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localRecommendAnchorInfo.jdField_b_of_type_Boolean = bool1;
    if (paramRcmdAnchor.video_preview.get() == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localRecommendAnchorInfo.jdField_c_of_type_Boolean = bool1;
    localRecommendAnchorInfo.jdField_d_of_type_Int = paramRcmdAnchor.microphone_flag.get();
    localRecommendAnchorInfo.jdField_g_of_type_JavaLangString = paramRcmdAnchor.icon_url.get();
    localRecommendAnchorInfo.jdField_a_of_type_JavaUtilList = paramRcmdAnchor.rich_title.elements.get();
    localRecommendAnchorInfo.i = paramRcmdAnchor.string_description.get();
    localRecommendAnchorInfo.h = paramRcmdAnchor.award_pendant_url.get();
    if (paramRcmdAnchor.extra_info.has())
    {
      NowQQLiveHomepageProto.UserExtraInfo localUserExtraInfo = (NowQQLiveHomepageProto.UserExtraInfo)paramRcmdAnchor.extra_info.get();
      if ((localUserExtraInfo.medal_info_list.has()) && (localUserExtraInfo.medal_info_list.get() != null) && (localUserExtraInfo.medal_info_list.size() > 0)) {
        localRecommendAnchorInfo.a(localUserExtraInfo.medal_info_list.get());
      }
    }
    localRecommendAnchorInfo.jdField_e_of_type_Int = paramRcmdAnchor.user_tag.color.get();
    try
    {
      if (!TextUtils.isEmpty(paramRcmdAnchor.user_tag.change_color.get())) {
        localRecommendAnchorInfo.jdField_f_of_type_Int = Integer.parseInt(paramRcmdAnchor.user_tag.change_color.get(), 16);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, localNumberFormatException, new Object[0]);
    }
    localRecommendAnchorInfo.k = paramRcmdAnchor.user_tag.pic_url.get();
    localRecommendAnchorInfo.l = paramRcmdAnchor.user_tag.wording.get();
    localRecommendAnchorInfo.jdField_e_of_type_JavaLangString = paramRcmdAnchor.string_jump_url.get();
    localRecommendAnchorInfo.jdField_g_of_type_Int = paramRcmdAnchor.user_tag.type.get();
    localRecommendAnchorInfo.n = paramRcmdAnchor.advertising_sign.get();
    return localRecommendAnchorInfo;
  }
  
  public int a(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return -1;
    }
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "parse data");
    if (paramInt <= 0)
    {
      this.jdField_a_of_type_JavaUtilSet.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_Int = 0;
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "clear state");
    }
    try
    {
      NowQQLiveHomepageProto.RecommendPageRsp localRecommendPageRsp = new NowQQLiveHomepageProto.RecommendPageRsp();
      localRecommendPageRsp.mergeFrom(paramArrayOfByte);
      this.jdField_c_of_type_Int = localRecommendPageRsp.uint32_new_timestamp.get();
      jdField_f_of_type_Int = localRecommendPageRsp.rcmd_col_mode.get();
      paramArrayOfByte = localRecommendPageRsp.rpt_msg_rcmd.get().iterator();
      while (paramArrayOfByte.hasNext())
      {
        localObject1 = (NowQQLiveHomepageProto.RecommendItem)paramArrayOfByte.next();
        Object localObject2;
        Object localObject3;
        if (this.jdField_a_of_type_JavaUtilSet.contains(((NowQQLiveHomepageProto.RecommendItem)localObject1).string_key.get()))
        {
          localObject2 = this.jdField_a_of_type_JavaLangString;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("去重： ");
          ((StringBuilder)localObject3).append(((NowQQLiveHomepageProto.RecommendItem)localObject1).string_key.get());
          QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
        }
        else
        {
          this.jdField_a_of_type_JavaUtilSet.add(((NowQQLiveHomepageProto.RecommendItem)localObject1).string_key.get());
          int i = ((NowQQLiveHomepageProto.RecommendItem)localObject1).uint32_type.get();
          if (i != 0)
          {
            if (i == 5)
            {
              localObject3 = (NowQQLiveHomepageProto.RcmdAnchor)((NowQQLiveHomepageProto.RecommendItem)localObject1).msg_anchor.get();
              localObject2 = ((NowQQLiveHomepageProto.RcmdAnchor)localObject3).string_id.get();
              if ((localObject2 != null) && (((String)localObject2).equals(BaseApplicationImpl.getApplication().getRuntime().getAccount())))
              {
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "主页过滤自己");
              }
              else
              {
                localObject2 = a((NowQQLiveHomepageProto.RcmdAnchor)localObject3);
                ((RecommendAnchorInfo)localObject2).jdField_a_of_type_JavaLangString = ((NowQQLiveHomepageProto.RecommendItem)localObject1).string_key.get();
                i = this.jdField_b_of_type_Int;
                this.jdField_b_of_type_Int = (i + 1);
                ((RecommendAnchorInfo)localObject2).jdField_a_of_type_Int = i;
                ((RecommendAnchorInfo)localObject2).o = ((NowQQLiveHomepageProto.RcmdAnchor)localObject3).union_channel_sign.get();
                localObject1 = this.jdField_a_of_type_JavaLangString;
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("NewRcmdDataMgr, parseData()  Double----anchor_union_channel_sign = ");
                ((StringBuilder)localObject3).append(((RecommendAnchorInfo)localObject2).o);
                QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
                this.jdField_a_of_type_JavaUtilList.add(localObject2);
              }
            }
          }
          else
          {
            localObject2 = (NowQQLiveHomepageProto.RcmdAnchor)((NowQQLiveHomepageProto.RecommendItem)localObject1).msg_anchor.get();
            localObject3 = ((NowQQLiveHomepageProto.RcmdAnchor)localObject2).string_id.get();
            if ((localObject3 != null) && (((String)localObject3).equals(BaseApplicationImpl.getApplication().getRuntime().getAccount())))
            {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "主页过滤自己");
            }
            else
            {
              localObject3 = a((NowQQLiveHomepageProto.RcmdAnchor)localObject2);
              ((RecommendAnchorInfo)localObject3).jdField_a_of_type_JavaLangString = ((NowQQLiveHomepageProto.RecommendItem)localObject1).string_key.get();
              i = this.jdField_b_of_type_Int;
              this.jdField_b_of_type_Int = (i + 1);
              ((RecommendAnchorInfo)localObject3).jdField_a_of_type_Int = i;
              ((RecommendAnchorInfo)localObject3).o = ((NowQQLiveHomepageProto.RcmdAnchor)localObject2).union_channel_sign.get();
              this.jdField_a_of_type_JavaUtilList.add(localObject3);
            }
          }
        }
      }
      paramArrayOfByte = this.jdField_a_of_type_JavaLangString;
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("第");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("开始拉取:");
      ((StringBuilder)localObject1).append(localRecommendPageRsp.rpt_msg_rcmd.get().size());
      ((StringBuilder)localObject1).append("个数据;");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilList.size());
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
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt, RecommendAnchorDataManager.RecommendAnchorDataCallback paramRecommendAnchorDataCallback, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_e_of_type_Int += 1;
      if (this.jdField_e_of_type_Int >= 3)
      {
        paramRecommendAnchorDataCallback.b();
        return;
      }
    }
    this.jdField_b_of_type_Boolean = true;
    NowQQLiveHomepageProto.RecommendPageReq localRecommendPageReq = new NowQQLiveHomepageProto.RecommendPageReq();
    if (TextUtils.isEmpty(BaseApplicationImpl.getApplication().getRuntime().getAccount())) {
      return;
    }
    localRecommendPageReq.uint32_last_update.set(this.jdField_c_of_type_Int);
    localRecommendPageReq.uint32_index.set(paramInt);
    NowQQLiveHomepageProto.UserMsgInfo localUserMsgInfo = new NowQQLiveHomepageProto.UserMsgInfo();
    localUserMsgInfo.type.set(1);
    localUserMsgInfo.desc.set(String.valueOf(2));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localUserMsgInfo);
    localRecommendPageReq.user_msg_info.set(localArrayList);
    localRecommendPageReq.channel.set("78711");
    localRecommendPageReq.rcmd_col_mode.set(jdField_f_of_type_Int);
    localRecommendPageReq.device_id.set(MobileInfoUtil.getImei());
    localRecommendPageReq.qimei.set(UserAction.getQIMEI());
    ChannelCenter.a().a(1718, 100, localRecommendPageReq.toByteArray(), new RecommendAnchorDataManager.1(this, paramInt, paramRecommendAnchorDataCallback));
  }
  
  public void a(RecommendAnchorDataManager.RecommendAnchorDataCallback paramRecommendAnchorDataCallback)
  {
    if (System.currentTimeMillis() > this.jdField_a_of_type_Long + 60000L) {
      a(0, paramRecommendAnchorDataCallback, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.recommend.RecommendAnchorDataManager
 * JD-Core Version:    0.7.0.1
 */