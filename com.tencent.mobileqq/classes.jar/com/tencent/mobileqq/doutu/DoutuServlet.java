package com.tencent.mobileqq.doutu;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.doutu.api.IDoutuService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.cs.doutu.Doutu.GetImgInfoReq;
import tencent.im.cs.doutu.Doutu.GetImgInfoRsp;
import tencent.im.cs.doutu.Doutu.ImgInfo;
import tencent.im.cs.doutu.Doutu.ReqBody;
import tencent.im.cs.doutu.Doutu.RspBody;
import tencent.im.cs.doutu.DoutuRecommend.GetImgInfoReq;
import tencent.im.cs.doutu.DoutuRecommend.GetImgInfoRsp;
import tencent.im.cs.doutu.DoutuRecommend.ImgInfo;
import tencent.im.cs.doutu.DoutuRecommend.ReqBody;
import tencent.im.cs.doutu.DoutuRecommend.RspBody;

public class DoutuServlet
  extends MSFServlet
{
  public List<DoutuData> a(List<DoutuRecommend.ImgInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DoutuRecommend.ImgInfo localImgInfo = (DoutuRecommend.ImgInfo)paramList.next();
        DoutuData localDoutuData = new DoutuData();
        localDoutuData.picMd5 = localImgInfo.bytes_pic_md5.get().toStringUtf8();
        localDoutuData.picSize = localImgInfo.uint64_pic_size.get();
        localDoutuData.picHeight = localImgInfo.uint32_pic_height.get();
        localDoutuData.picWidth = localImgInfo.uint32_pic_width.get();
        localDoutuData.picDownUrl = localImgInfo.bytes_pic_down_url.get().toStringUtf8();
        localDoutuData.thumbMd5 = localImgInfo.bytes_thumb_file_md5.get().toStringUtf8().toUpperCase();
        localDoutuData.thumbSize = localImgInfo.uint64_thumb_size.get();
        localDoutuData.thumbHeight = localImgInfo.uint32_thumb_height.get();
        localDoutuData.thumbWidth = localImgInfo.uint32_thumb_width.get();
        localDoutuData.thumbDownUrl = localImgInfo.bytes_thumb_down_url.get().toStringUtf8();
        localDoutuData.suppliersName = localImgInfo.bytes_source_name.get().toStringUtf8();
        localArrayList.add(localDoutuData);
      }
      return localArrayList;
    }
    return null;
  }
  
  public List<DoutuData> a(List<Doutu.ImgInfo> paramList, int paramInt)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Doutu.ImgInfo localImgInfo = (Doutu.ImgInfo)paramList.next();
        DoutuData localDoutuData = new DoutuData();
        localDoutuData.picMd5 = localImgInfo.bytes_pic_md5.get().toStringUtf8();
        localDoutuData.picSize = localImgInfo.uint64_pic_size.get();
        localDoutuData.picHeight = localImgInfo.uint32_pic_height.get();
        localDoutuData.picWidth = localImgInfo.uint32_pic_width.get();
        localDoutuData.picDownUrl = localImgInfo.bytes_pic_down_url.get().toStringUtf8();
        localDoutuData.thumbMd5 = localImgInfo.bytes_thumb_file_md5.get().toStringUtf8().toUpperCase();
        localDoutuData.thumbSize = localImgInfo.uint64_thumb_size.get();
        localDoutuData.thumbHeight = localImgInfo.uint32_thumb_height.get();
        localDoutuData.thumbWidth = localImgInfo.uint32_thumb_width.get();
        localDoutuData.thumbDownUrl = localImgInfo.bytes_thumb_down_url.get().toStringUtf8();
        localDoutuData.suppliersName = localImgInfo.bytes_source_name.get().toStringUtf8();
        if (paramInt > 0) {
          localDoutuData.picType = paramInt;
        }
        localArrayList.add(localDoutuData);
      }
      return localArrayList;
    }
    return null;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int i = -1;
    int j = paramIntent.getIntExtra("KEY_CMD", -1);
    long l = paramIntent.getLongExtra("key_sequence", 0L);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onReceive, cmd = ");
      paramIntent.append(j);
      paramIntent.append(", key:");
      paramIntent.append(l);
      QLog.i("DoutuServlet", 2, paramIntent.toString());
    }
    boolean bool;
    if (paramFromServiceMsg == null) {
      bool = false;
    } else {
      bool = paramFromServiceMsg.isSuccess();
    }
    paramIntent = (IDoutuService)getAppRuntime().getRuntimeService(IDoutuService.class, "");
    if (bool)
    {
      try
      {
        Object localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        if (j != 1)
        {
          if (j != 5)
          {
            if (j != 6) {
              return;
            }
            localObject = new DoutuRecommend.RspBody();
            ((DoutuRecommend.RspBody)localObject).mergeFrom(paramFromServiceMsg);
            paramFromServiceMsg = (DoutuRecommend.GetImgInfoRsp)((DoutuRecommend.RspBody)localObject).msg_get_imginfo_rsp.get();
            i = paramFromServiceMsg.int32_result.get();
            if (i == 0)
            {
              paramIntent.handleGetRecommendPicList(true, a(paramFromServiceMsg.rpt_msg_img_info.get()), l);
              return;
            }
            if (paramIntent != null) {
              paramIntent.handleGetRecommendPicList(false, null, l);
            }
            paramIntent = paramFromServiceMsg.bytes_fail_msg.get().toStringUtf8();
            if (!QLog.isColorLevel()) {
              break label638;
            }
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("onReceive recommend Failed result:");
            paramFromServiceMsg.append(i);
            paramFromServiceMsg.append(", errMsg:");
            paramFromServiceMsg.append(paramIntent);
            QLog.i("DoutuServlet", 2, paramFromServiceMsg.toString());
            return;
          }
          if (!QLog.isColorLevel()) {
            break label638;
          }
          QLog.d("DoutuServlet", 2, "onReceive CMD_REPORT_NEW  success .");
          return;
        }
        localObject = new Doutu.RspBody();
        ((Doutu.RspBody)localObject).mergeFrom(paramFromServiceMsg);
        paramFromServiceMsg = (Doutu.GetImgInfoRsp)((Doutu.RspBody)localObject).msg_get_imginfo_rsp.get();
        i = paramFromServiceMsg.int32_result.get();
        if (i == 0)
        {
          localObject = paramFromServiceMsg.rpt_msg_img_info.get();
          if ((localObject != null) && (((List)localObject).size() != 0))
          {
            paramIntent.handleGetDoutuList(true, a((List)localObject, paramFromServiceMsg.uint32_rsp_type.get()));
            return;
          }
          if (paramIntent != null) {
            paramIntent.handleGetDoutuList(false, null);
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("DoutuServlet", 2, "onReceive: rpt_msg_img_info is null");
          return;
        }
        if (paramIntent != null) {
          paramIntent.handleGetDoutuList(false, null);
        }
        paramFromServiceMsg = paramFromServiceMsg.bytes_fail_msg.get().toStringUtf8();
        paramIntent = paramFromServiceMsg;
        if (paramFromServiceMsg == null) {
          paramIntent = "null";
        }
        if (!QLog.isColorLevel()) {
          break label638;
        }
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("onReceive : Failed ! result = ");
        paramFromServiceMsg.append(i);
        paramFromServiceMsg.append(", errMsg = ");
        paramFromServiceMsg.append(paramIntent);
        QLog.i("DoutuServlet", 2, paramFromServiceMsg.toString());
        return;
      }
      catch (InvalidProtocolBufferMicroException paramIntent)
      {
        if (!QLog.isColorLevel()) {
          break label638;
        }
      }
      QLog.e("DoutuServlet", 2, paramIntent, new Object[0]);
    }
    else
    {
      if (paramFromServiceMsg != null) {
        i = paramFromServiceMsg.getResultCode();
      }
      if (j != 1)
      {
        if ((j == 6) && (paramIntent != null)) {
          paramIntent.handleGetRecommendPicTimeOut(l);
        }
      }
      else if (paramIntent != null) {
        paramIntent.handleGetDoutuList(false, null);
      }
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onReceive : Failed, errCode:");
        paramIntent.append(i);
        paramIntent.append(", cmd:");
        paramIntent.append(j);
        QLog.i("DoutuServlet", 2, paramIntent.toString());
      }
    }
    label638:
    return;
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("KEY_CMD", -1);
    Object localObject1;
    long l1;
    long l2;
    int j;
    int k;
    if (i != 1)
    {
      String str;
      Object localObject2;
      if (i != 5)
      {
        if (i != 6)
        {
          paramIntent = null;
          localObject1 = null;
        }
        else
        {
          localObject1 = new DoutuRecommend.GetImgInfoReq();
          l1 = paramIntent.getLongExtra("KEY_SRC_UIN", 0L);
          l2 = paramIntent.getLongExtra("KEY_TO_UIN", 0L);
          str = paramIntent.getStringExtra("KEY_MD5");
          i = paramIntent.getByteExtra("KEY_AGE", (byte)0);
          j = paramIntent.getShortExtra("key_gender", (short)0);
          localObject2 = paramIntent.getStringExtra("key_url");
          k = paramIntent.getIntExtra("KEY_SESSION_TYPE", 0);
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("onSend,CMD_RECOMMEND, srcUin1:");
            paramIntent.append(l1);
            paramIntent.append(", md5Str:");
            paramIntent.append(str);
            paramIntent.append(", age = ");
            paramIntent.append(i);
            paramIntent.append(", gender:");
            paramIntent.append(j);
            QLog.i("DoutuServlet", 2, paramIntent.toString());
          }
          ((DoutuRecommend.GetImgInfoReq)localObject1).uint64_src_uin.set(l1);
          ((DoutuRecommend.GetImgInfoReq)localObject1).uint64_to_uin.set(l2);
          ((DoutuRecommend.GetImgInfoReq)localObject1).uint32_src_term.set(2);
          if (!TextUtils.isEmpty(str)) {
            ((DoutuRecommend.GetImgInfoReq)localObject1).bytes_md5.set(ByteStringMicro.copyFrom(str.getBytes()));
          }
          if (k == 1) {
            ((DoutuRecommend.GetImgInfoReq)localObject1).chat_type.set(1);
          } else if (k == 2) {
            ((DoutuRecommend.GetImgInfoReq)localObject1).chat_type.set(2);
          } else {
            ((DoutuRecommend.GetImgInfoReq)localObject1).chat_type.set(255);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            ((DoutuRecommend.GetImgInfoReq)localObject1).bytes_url.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
          }
          ((DoutuRecommend.GetImgInfoReq)localObject1).uin32_gender.set(j);
          ((DoutuRecommend.GetImgInfoReq)localObject1).uint32_age.set(i);
          paramIntent = new DoutuRecommend.ReqBody();
          paramIntent.msg_get_imginfo_req.set((MessageMicro)localObject1);
          localObject1 = WupUtil.a(paramIntent.toByteArray());
          paramPacket.setTimeout(3000L);
          paramIntent = "ImageFightRecSvc.GetImage";
        }
      }
      else
      {
        localObject1 = WupUtil.a(paramIntent.getStringExtra("key_report_content").getBytes());
        if (QLog.isColorLevel())
        {
          str = paramIntent.getStringExtra("key_report_content");
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onSend,CMD_REPORT_NEW, REPORT_CONTENT :");
          paramIntent = str;
          if (str == null) {
            paramIntent = "null";
          }
          ((StringBuilder)localObject2).append(paramIntent);
          QLog.d("DoutuServlet", 2, ((StringBuilder)localObject2).toString());
        }
        paramIntent = "MQInference.CommonReport";
      }
    }
    else
    {
      localObject1 = new Doutu.GetImgInfoReq();
      l1 = paramIntent.getLongExtra("KEY_SRC_UIN", 0L);
      l2 = paramIntent.getLongExtra("KEY_TO_UIN", 0L);
      i = paramIntent.getIntExtra("KEY_SESSION_TYPE", 0);
      j = paramIntent.getByteExtra("KEY_AGE", (byte)0);
      k = paramIntent.getShortExtra("key_gender", (short)0);
      ((Doutu.GetImgInfoReq)localObject1).uint64_src_uin.set(l1);
      ((Doutu.GetImgInfoReq)localObject1).uint64_to_uin.set(l2);
      ((Doutu.GetImgInfoReq)localObject1).uint32_age.set(j);
      ((Doutu.GetImgInfoReq)localObject1).uint32_src_term.set(2);
      ((Doutu.GetImgInfoReq)localObject1).uin32_gender.set(k);
      if (i == 1) {
        ((Doutu.GetImgInfoReq)localObject1).chat_type.set(1);
      } else if (i == 2) {
        ((Doutu.GetImgInfoReq)localObject1).chat_type.set(2);
      } else {
        ((Doutu.GetImgInfoReq)localObject1).chat_type.set(255);
      }
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onSend, CMD_DOU_TU , src_uin = ");
        paramIntent.append(l1);
        paramIntent.append(", age = ");
        paramIntent.append(j);
        paramIntent.append(", gender:");
        paramIntent.append(k);
        paramIntent.append(", chatType:");
        paramIntent.append(i);
        paramIntent.append(", toUin:");
        paramIntent.append(l2);
        QLog.i("DoutuServlet", 2, paramIntent.toString());
      }
      paramIntent = new Doutu.ReqBody();
      paramIntent.msg_get_imginfo_req.set((MessageMicro)localObject1);
      localObject1 = WupUtil.a(paramIntent.toByteArray());
      paramIntent = "ImageFight.GetInfo";
    }
    if ((paramIntent != null) && (localObject1 != null))
    {
      paramPacket.setSSOCommand(paramIntent);
      paramPacket.putSendData((byte[])localObject1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("DoutuServlet", 2, "exception request!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuServlet
 * JD-Core Version:    0.7.0.1
 */