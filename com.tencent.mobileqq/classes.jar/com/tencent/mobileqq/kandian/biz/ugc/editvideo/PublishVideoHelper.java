package com.tencent.mobileqq.kandian.biz.ugc.editvideo;

import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.AddVideoReq;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.MoveVideoReq;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.ReqBody;

public class PublishVideoHelper
{
  public static void a(List<String> paramList, int paramInt, @Nullable PublishVideoHelper.IMoveUgcVideoCallback paramIMoveUgcVideoCallback)
  {
    oidb_0xe2a.MoveVideoReq localMoveVideoReq = new oidb_0xe2a.MoveVideoReq();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!TextUtils.isEmpty(str)) {
        localMoveVideoReq.rpt_rowkey_list.add(ByteStringMicro.copyFromUtf8(str));
      }
    }
    localMoveVideoReq.uint32_column_id.set(paramInt);
    localMoveVideoReq.uint32_oper_type.set(1);
    paramList = new oidb_0xe2a.ReqBody();
    paramList.msg_move_video_req.set(localMoveVideoReq);
    ProtoUtils.a(RIJQQAppInterfaceUtil.a(), new PublishVideoHelper.2(paramIMoveUgcVideoCallback, paramInt), paramList.toByteArray(), "OidbSvc.0xe2a", 3626, 2);
  }
  
  public static void a(boolean paramBoolean1, List<UgcVideo> paramList, @Nullable PublishVideoHelper.IPublishVideoCallback paramIPublishVideoCallback, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((UgcVideo)paramList.next()).parseUgcVideo());
    }
    paramList = new oidb_0xe2a.ReqBody();
    oidb_0xe2a.AddVideoReq localAddVideoReq = new oidb_0xe2a.AddVideoReq();
    localAddVideoReq.rpt_video_list.set(localArrayList);
    localAddVideoReq.uint32_add_video_type.set(paramBoolean1 ^ true);
    paramList.msg_add_video_req.set(localAddVideoReq);
    ProtoUtils.a(RIJQQAppInterfaceUtil.a(), new PublishVideoHelper.1(paramBoolean2, paramIPublishVideoCallback), paramList.toByteArray(), "OidbSvc.0xe2a", 3626, 1, null, 120000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.editvideo.PublishVideoHelper
 * JD-Core Version:    0.7.0.1
 */