package com.tencent.mobileqq.doutu;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
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
import tencent.im.cs.doutu.Doutu.GetHotPicReq;
import tencent.im.cs.doutu.Doutu.GetImgInfoReq;
import tencent.im.cs.doutu.Doutu.GetImgInfoRsp;
import tencent.im.cs.doutu.Doutu.GetShanMengReq;
import tencent.im.cs.doutu.Doutu.ImgInfo;
import tencent.im.cs.doutu.Doutu.ReportHotPicReq;
import tencent.im.cs.doutu.Doutu.ReqBody;
import tencent.im.cs.doutu.Doutu.RspBody;

public class DoutuServlet
  extends MSFServlet
{
  public List a(List paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Doutu.ImgInfo localImgInfo = (Doutu.ImgInfo)paramList.next();
      DoutuData localDoutuData = new DoutuData();
      localDoutuData.pic_md5 = localImgInfo.bytes_pic_md5.get().toStringUtf8();
      localDoutuData.pic_size = localImgInfo.uint64_pic_size.get();
      localDoutuData.pic_height = localImgInfo.uint32_pic_height.get();
      localDoutuData.pic_width = localImgInfo.uint32_pic_width.get();
      localDoutuData.pic_down_url = localImgInfo.bytes_pic_down_url.get().toStringUtf8();
      localDoutuData.thumb_md5 = localImgInfo.bytes_thumb_file_md5.get().toStringUtf8().toUpperCase();
      localDoutuData.thumb_size = localImgInfo.uint64_thumb_size.get();
      localDoutuData.thumb_height = localImgInfo.uint32_thumb_height.get();
      localDoutuData.thumb_width = localImgInfo.uint32_thumb_width.get();
      localDoutuData.thumb_down_url = localImgInfo.bytes_thumb_down_url.get().toStringUtf8();
      localDoutuData.suppliers_name = localImgInfo.bytes_source_name.get().toStringUtf8();
      if (paramInt > 0) {
        localDoutuData.pic_type = paramInt;
      }
      localArrayList.add(localDoutuData);
    }
    return localArrayList;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int j = paramIntent.getIntExtra("KEY_CMD", -1);
    long l = paramIntent.getLongExtra("key_sequence", 0L);
    if (QLog.isColorLevel()) {
      QLog.i("DoutuServlet", 2, "onReceive, cmd = " + j + ", key:" + l);
    }
    boolean bool;
    if (paramFromServiceMsg == null)
    {
      bool = false;
      paramIntent = (DoutuManager)getAppRuntime().getManager(213);
      if (!bool) {
        break label584;
      }
    }
    label698:
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        localObject = new Doutu.RspBody();
        ((Doutu.RspBody)localObject).mergeFrom(paramFromServiceMsg);
        switch (j)
        {
        default: 
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramIntent)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("DoutuServlet", 2, paramIntent, new Object[0]);
        return;
      }
      bool = paramFromServiceMsg.isSuccess();
      break;
      paramFromServiceMsg = (Doutu.GetImgInfoRsp)((Doutu.RspBody)localObject).msg_get_imginfo_rsp.get();
      int i = paramFromServiceMsg.int32_result.get();
      if (i == 0)
      {
        localObject = paramFromServiceMsg.rpt_msg_img_info.get();
        if ((localObject == null) || (((List)localObject).size() == 0))
        {
          if (paramIntent != null) {
            paramIntent.a(false, null);
          }
          if (QLog.isColorLevel()) {
            QLog.i("DoutuServlet", 2, "onReceive: rpt_msg_img_info is null");
          }
        }
        else
        {
          paramIntent.a(true, a((List)localObject, paramFromServiceMsg.uint32_rsp_type.get()));
        }
      }
      else
      {
        if (paramIntent != null) {
          paramIntent.a(false, null);
        }
        paramFromServiceMsg = paramFromServiceMsg.bytes_fail_msg.get().toStringUtf8();
        paramIntent = paramFromServiceMsg;
        if (paramFromServiceMsg == null) {
          paramIntent = "null";
        }
        if (QLog.isColorLevel())
        {
          QLog.i("DoutuServlet", 2, "onReceive : Failed ! result = " + i + ", errMsg = " + paramIntent);
          return;
          paramFromServiceMsg = (Doutu.GetImgInfoRsp)((Doutu.RspBody)localObject).msg_get_imginfo_rsp.get();
          i = paramFromServiceMsg.int32_result.get();
          if (i == 0)
          {
            localObject = paramFromServiceMsg.rpt_msg_img_info.get();
            i = paramFromServiceMsg.uint32_rsp_type.get();
            paramIntent.a(true, a((List)localObject, i), i, j, l);
            return;
          }
          if (paramIntent != null) {
            paramIntent.a(false, null, 0, j, l);
          }
          paramIntent = paramFromServiceMsg.bytes_fail_msg.get().toStringUtf8();
          if (QLog.isColorLevel())
          {
            QLog.i("DoutuServlet", 2, "onReceive hot Failed result:" + i + ", errMsg:" + paramIntent);
            return;
            paramIntent = (Doutu.GetImgInfoRsp)((Doutu.RspBody)localObject).msg_get_imginfo_rsp.get();
            i = paramIntent.int32_result.get();
            if (QLog.isColorLevel()) {
              QLog.d("DoutuServlet", 2, "onReceive reportResult:" + i);
            }
            if (i != 0)
            {
              paramIntent = paramIntent.bytes_fail_msg.get().toStringUtf8();
              if (QLog.isColorLevel())
              {
                QLog.i("DoutuServlet", 2, "onReceive : report Failed errMsg:" + paramIntent);
                return;
                label584:
                if (paramFromServiceMsg == null)
                {
                  i = -1;
                  switch (j)
                  {
                  }
                }
                for (;;)
                {
                  if (!QLog.isColorLevel()) {
                    break label698;
                  }
                  QLog.i("DoutuServlet", 2, "onReceive : Failed, errCode:" + i + ", cmd:" + j);
                  return;
                  i = paramFromServiceMsg.getResultCode();
                  break;
                  if (paramIntent != null)
                  {
                    paramIntent.a(false, null);
                    continue;
                    if (paramIntent != null) {
                      paramIntent.a(j, l);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("KEY_CMD", -1);
    Object localObject1 = null;
    Object localObject2 = null;
    switch (i)
    {
    default: 
      paramIntent = (Intent)localObject2;
      if ((localObject1 != null) && (paramIntent != null))
      {
        paramPacket.setSSOCommand((String)localObject1);
        paramPacket.putSendData(paramIntent);
      }
      break;
    }
    while (!QLog.isColorLevel())
    {
      return;
      localObject1 = new Doutu.GetImgInfoReq();
      long l = paramIntent.getLongExtra("KEY_SRC_UIN", 0L);
      i = paramIntent.getByteExtra("KEY_AGE", (byte)0);
      int j = paramIntent.getShortExtra("key_gender", (short)0);
      ((Doutu.GetImgInfoReq)localObject1).uint64_src_uin.set(l);
      ((Doutu.GetImgInfoReq)localObject1).uint32_age.set(i);
      ((Doutu.GetImgInfoReq)localObject1).uint32_src_term.set(2);
      ((Doutu.GetImgInfoReq)localObject1).uin32_gender.set(j);
      if (QLog.isColorLevel()) {
        QLog.i("DoutuServlet", 2, "onSend : src_uin = " + l + ", age = " + i + ", gender:" + j);
      }
      paramIntent = new Doutu.ReqBody();
      paramIntent.msg_get_imginfo_req.set((MessageMicro)localObject1);
      localObject1 = "ImageFight.GetInfo";
      paramIntent = WupUtil.a(paramIntent.toByteArray());
      break;
      localObject1 = new Doutu.GetHotPicReq();
      l = paramIntent.getLongExtra("KEY_SRC_UIN", 0L);
      localObject2 = paramIntent.getStringExtra("KEY_MD5");
      i = paramIntent.getByteExtra("KEY_AGE", (byte)0);
      j = paramIntent.getShortExtra("key_gender", (short)0);
      if (QLog.isColorLevel()) {
        QLog.i("DoutuServlet", 2, "onSend hotPicUin:" + l + ", md5Str:" + (String)localObject2 + ", age = " + i + ", gender:" + j);
      }
      ((Doutu.GetHotPicReq)localObject1).uint64_src_uin.set(l);
      ((Doutu.GetHotPicReq)localObject1).uint32_src_term.set(2);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((Doutu.GetHotPicReq)localObject1).bytes_pic_md5.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
      }
      ((Doutu.GetHotPicReq)localObject1).uin32_gender.set(j);
      ((Doutu.GetHotPicReq)localObject1).uint32_age.set(i);
      paramIntent = new Doutu.ReqBody();
      paramIntent.msg_get_hotpic_req.set((MessageMicro)localObject1);
      localObject1 = "ImageFight.GetHotPic";
      paramIntent = WupUtil.a(paramIntent.toByteArray());
      paramPacket.setTimeout(3000L);
      break;
      localObject1 = new Doutu.GetShanMengReq();
      l = paramIntent.getLongExtra("KEY_SRC_UIN", 0L);
      localObject2 = paramIntent.getStringExtra("KEY_UUID");
      String str1 = paramIntent.getStringExtra("KEY_MD5");
      i = paramIntent.getIntExtra("KEY_SESSION_TYPE", 0);
      String str2 = paramIntent.getStringExtra("key_url");
      j = paramIntent.getByteExtra("KEY_AGE", (byte)0);
      int k = paramIntent.getShortExtra("key_gender", (short)0);
      if (QLog.isColorLevel()) {
        QLog.i("DoutuServlet", 2, "onSend shanMengUin:" + l + ", uuid:" + (String)localObject2 + ", url:" + str2 + ", md5:" + str1 + ", type:" + i + ", age:" + j + ", gender:" + k);
      }
      ((Doutu.GetShanMengReq)localObject1).uint64_src_uin.set(l);
      ((Doutu.GetShanMengReq)localObject1).uint32_src_term.set(2);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((Doutu.GetShanMengReq)localObject1).bytes_uuid.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
      }
      if (!TextUtils.isEmpty(str1)) {
        ((Doutu.GetShanMengReq)localObject1).bytes_md5.set(ByteStringMicro.copyFrom(str1.getBytes()));
      }
      ((Doutu.GetShanMengReq)localObject1).uint32_command_id.set(i);
      if (!TextUtils.isEmpty(str2)) {
        ((Doutu.GetShanMengReq)localObject1).bytes_url.set(ByteStringMicro.copyFrom(str2.getBytes()));
      }
      ((Doutu.GetShanMengReq)localObject1).uin32_gender.set(k);
      ((Doutu.GetShanMengReq)localObject1).uint32_age.set(j);
      paramIntent = new Doutu.ReqBody();
      paramIntent.msg_get_shanmeng_req.set((MessageMicro)localObject1);
      localObject1 = "ImageFight.GetShanMeng";
      paramIntent = WupUtil.a(paramIntent.toByteArray());
      paramPacket.setTimeout(3000L);
      break;
      localObject1 = new Doutu.ReportHotPicReq();
      l = paramIntent.getLongExtra("KEY_SRC_UIN", 0L);
      localObject2 = (DoutuData)paramIntent.getParcelableExtra("KEY_IMAGE_INFO");
      str1 = paramIntent.getStringExtra("KEY_MD5");
      i = paramIntent.getByteExtra("KEY_AGE", (byte)0);
      j = paramIntent.getShortExtra("key_gender", (short)0);
      ((Doutu.ReportHotPicReq)localObject1).uint64_src_uin.set(l);
      ((Doutu.ReportHotPicReq)localObject1).uint32_src_term.set(2);
      if (localObject2 != null)
      {
        paramIntent = new Doutu.ImgInfo();
        if (!TextUtils.isEmpty(((DoutuData)localObject2).pic_md5)) {
          paramIntent.bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((DoutuData)localObject2).pic_md5));
        }
        paramIntent.uint64_pic_size.set(((DoutuData)localObject2).pic_size);
        paramIntent.uint32_pic_width.set(((DoutuData)localObject2).pic_width);
        paramIntent.uint32_pic_height.set(((DoutuData)localObject2).pic_height);
        if (!TextUtils.isEmpty(((DoutuData)localObject2).pic_down_url)) {
          paramIntent.bytes_pic_down_url.set(ByteStringMicro.copyFromUtf8(((DoutuData)localObject2).pic_down_url));
        }
        if (!TextUtils.isEmpty(((DoutuData)localObject2).thumb_md5)) {
          paramIntent.bytes_thumb_file_md5.set(ByteStringMicro.copyFromUtf8(((DoutuData)localObject2).thumb_md5));
        }
        paramIntent.uint64_thumb_size.set(((DoutuData)localObject2).thumb_size);
        paramIntent.uint32_thumb_width.set(((DoutuData)localObject2).thumb_width);
        paramIntent.uint32_thumb_height.set(((DoutuData)localObject2).thumb_height);
        if (!TextUtils.isEmpty(((DoutuData)localObject2).thumb_down_url)) {
          paramIntent.bytes_thumb_down_url.set(ByteStringMicro.copyFromUtf8(((DoutuData)localObject2).thumb_down_url));
        }
        if (!TextUtils.isEmpty(((DoutuData)localObject2).suppliers_name)) {
          paramIntent.bytes_source_name.set(ByteStringMicro.copyFromUtf8(((DoutuData)localObject2).suppliers_name));
        }
        ((Doutu.ReportHotPicReq)localObject1).msg_img_info.set(paramIntent);
      }
      if (!TextUtils.isEmpty(str1)) {
        ((Doutu.ReportHotPicReq)localObject1).bytes_md5.set(ByteStringMicro.copyFromUtf8(str1));
      }
      ((Doutu.ReportHotPicReq)localObject1).uin32_gender.set(j);
      ((Doutu.ReportHotPicReq)localObject1).uint32_age.set(i);
      paramIntent = new Doutu.ReqBody();
      paramIntent.msg_report_hotpic_req.set((MessageMicro)localObject1);
      localObject1 = "ImageFight.ReportHotPic";
      paramIntent = WupUtil.a(paramIntent.toByteArray());
      break;
    }
    QLog.e("DoutuServlet", 2, "exception request!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuServlet
 * JD-Core Version:    0.7.0.1
 */