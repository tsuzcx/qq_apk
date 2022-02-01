package com.tencent.mobileqq.pic.operator.multipic;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPicUpResp;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.NotOnlineImage;

public class MultiPicsBaseClass
{
  private volatile long jdField_a_of_type_Long;
  MultiPicsOperator.MultiPicsUploadTask jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator$MultiPicsUploadTask;
  public String a;
  protected WeakReference<QQAppInterface> a;
  ArrayList<PicResult> jdField_a_of_type_JavaUtilArrayList;
  List<PicFowardInfo> jdField_a_of_type_JavaUtilList;
  private Random jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
  public String b;
  
  public MultiPicsBaseClass(MultiPicsOperator.MultiPicsUploadTask paramMultiPicsUploadTask, WeakReference<QQAppInterface> paramWeakReference)
  {
    this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator$MultiPicsUploadTask = paramMultiPicsUploadTask;
    this.jdField_a_of_type_JavaUtilArrayList = paramMultiPicsUploadTask.jdField_a_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_JavaUtilList = paramMultiPicsUploadTask.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_JavaLangString = paramMultiPicsUploadTask.jdField_a_of_type_JavaLangString;
    this.b = paramMultiPicsUploadTask.b;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  int a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          if (((PicResult)localIterator.next()).jdField_a_of_type_Int == -2) {
            i += 1;
          }
        }
        else {
          return i;
        }
      }
      finally {}
    }
  }
  
  String a(im_msg_body.CustomFace paramCustomFace)
  {
    if ((!QLog.isColorLevel()) || (paramCustomFace == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[CustomFace]uint32_server_ip:" + paramCustomFace.uint32_server_ip.get());
    localStringBuilder.append(",uint32_server_port:" + paramCustomFace.uint32_server_port.get());
    localStringBuilder.append(",uint32_file_id:" + paramCustomFace.uint32_file_id.get());
    localStringBuilder.append(",bytes_md5:" + HexUtil.bytes2HexStr(paramCustomFace.bytes_md5.get().toByteArray()));
    localStringBuilder.append(",str_file_path:" + paramCustomFace.str_file_path.get());
    localStringBuilder.append(",uint32_origin:" + paramCustomFace.uint32_origin.get());
    localStringBuilder.append(",uint32_width:" + paramCustomFace.uint32_width.get());
    localStringBuilder.append(",uint32_height:" + paramCustomFace.uint32_height.get());
    localStringBuilder.append(",uint32_height:" + paramCustomFace.uint32_height.get());
    localStringBuilder.append(",image_type:" + paramCustomFace.image_type.get());
    return localStringBuilder.toString();
  }
  
  String a(im_msg_body.NotOnlineImage paramNotOnlineImage)
  {
    if ((!QLog.isColorLevel()) || (paramNotOnlineImage == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[NotOnlineImage]file_path:" + paramNotOnlineImage.file_path.get().toStringUtf8());
    localStringBuilder.append(",file_len:" + paramNotOnlineImage.file_len.get());
    localStringBuilder.append(",download_path:" + paramNotOnlineImage.download_path.get().toStringUtf8());
    localStringBuilder.append(",res_id:" + paramNotOnlineImage.res_id.get().toStringUtf8());
    localStringBuilder.append(",pic_md5:" + HexUtil.bytes2HexStr(paramNotOnlineImage.pic_md5.get().toByteArray()));
    localStringBuilder.append(",pic_height:" + paramNotOnlineImage.pic_height.get());
    localStringBuilder.append(",pic_width:" + paramNotOnlineImage.pic_width.get());
    localStringBuilder.append(",original:" + paramNotOnlineImage.original.get());
    localStringBuilder.append(",img_type:" + paramNotOnlineImage.img_type.get());
    localStringBuilder.append(",uint32_file_id:" + paramNotOnlineImage.uint32_file_id.get());
    return localStringBuilder.toString();
  }
  
  im_msg_body.CustomFace a(RichProto.RichProtoReq.PicUpReq paramPicUpReq, RichProto.RichProtoResp.GroupPicUpResp paramGroupPicUpResp, int paramInt)
  {
    im_msg_body.CustomFace localCustomFace = new im_msg_body.CustomFace();
    for (;;)
    {
      PicFowardInfo localPicFowardInfo;
      try
      {
        localPicFowardInfo = (PicFowardInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (paramGroupPicUpResp != null)
        {
          localCustomFace.uint32_file_id.set((int)paramGroupPicUpResp.groupFileID);
          if ((paramGroupPicUpResp.mIpList != null) && (paramGroupPicUpResp.mIpList.size() > 0))
          {
            paramGroupPicUpResp = (ServerAddr)paramGroupPicUpResp.mIpList.get(0);
            localCustomFace.uint32_server_ip.set(GroupPicUploadProcessor.ipToLong(paramGroupPicUpResp.mIp));
            localCustomFace.uint32_server_port.set(paramGroupPicUpResp.port);
          }
          localCustomFace.uint32_file_type.set(Integer.valueOf(66).intValue());
          localCustomFace.uint32_useful.set(1);
          if (((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSessionKey() != null) {
            localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSessionKey()));
          }
          if (paramPicUpReq == null) {
            break label439;
          }
          localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(paramPicUpReq.md5));
          localCustomFace.str_file_path.set(paramPicUpReq.fileName);
          paramGroupPicUpResp = localCustomFace.uint32_origin;
          if (paramPicUpReq.isRaw)
          {
            i = 1;
            paramGroupPicUpResp.set(i);
            localCustomFace.uint32_width.set(paramPicUpReq.width);
            localCustomFace.uint32_height.set(paramPicUpReq.height);
            localCustomFace.uint32_size.set((int)paramPicUpReq.fileSize);
            localCustomFace.biz_type.set(4);
            localCustomFace.uint32_source.set(104);
            localCustomFace.uint32_thumb_width.set(localPicFowardInfo.a.e);
            localCustomFace.uint32_thumb_height.set(localPicFowardInfo.a.f);
            localCustomFace.image_type.set(localPicFowardInfo.a.m);
            Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] OK, " + a(localCustomFace));
            return localCustomFace;
          }
        }
        else
        {
          localCustomFace.uint32_file_id.set(0);
          continue;
        }
        int i = 0;
      }
      catch (Exception paramPicUpReq)
      {
        Logger.b(this.b, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] failed, Exception, " + paramPicUpReq.toString());
        return null;
      }
      continue;
      label439:
      localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
      localCustomFace.str_file_path.set("bad");
      localCustomFace.uint32_origin.set(0);
      localCustomFace.uint32_width.set(localPicFowardInfo.a.j);
      localCustomFace.uint32_height.set(localPicFowardInfo.a.k);
      localCustomFace.uint32_size.set(0);
    }
  }
  
  im_msg_body.CustomFace a(im_msg_body.NotOnlineImage paramNotOnlineImage)
  {
    im_msg_body.CustomFace localCustomFace = new im_msg_body.CustomFace();
    try
    {
      localCustomFace.uint32_file_id.set(paramNotOnlineImage.uint32_file_id.get());
      localCustomFace.uint32_file_type.set(Integer.valueOf(66).intValue());
      localCustomFace.uint32_useful.set(1);
      if (((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSessionKey() != null) {
        localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSessionKey()));
      }
      localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(paramNotOnlineImage.pic_md5.get().toByteArray()));
      if (paramNotOnlineImage.res_id.has()) {
        localCustomFace.str_file_path.set(paramNotOnlineImage.res_id.get().toStringUtf8());
      }
      for (;;)
      {
        localCustomFace.uint32_origin.set(paramNotOnlineImage.original.get());
        localCustomFace.biz_type.set(4);
        localCustomFace.uint32_source.set(104);
        localCustomFace.uint32_width.set(paramNotOnlineImage.pic_width.get());
        localCustomFace.uint32_height.set(paramNotOnlineImage.pic_height.get());
        localCustomFace.uint32_size.set(paramNotOnlineImage.file_len.get());
        localCustomFace.uint32_thumb_width.set(paramNotOnlineImage.uint32_thumb_width.get());
        localCustomFace.uint32_thumb_height.set(paramNotOnlineImage.uint32_thumb_height.get());
        localCustomFace.image_type.set(paramNotOnlineImage.img_type.get());
        Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.convert2CustomFace", a(localCustomFace));
        return localCustomFace;
        if (paramNotOnlineImage.download_path.has()) {
          localCustomFace.str_file_path.set(paramNotOnlineImage.download_path.get().toStringUtf8());
        }
      }
      return null;
    }
    catch (Exception paramNotOnlineImage)
    {
      Logger.b(this.b, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.convert2CustomFace", "Exception, " + paramNotOnlineImage.toString());
    }
  }
  
  im_msg_body.NotOnlineImage a(RichProto.RichProtoReq.PicUpReq paramPicUpReq, RichProto.RichProtoResp.C2CPicUpResp paramC2CPicUpResp, int paramInt)
  {
    int i = 0;
    im_msg_body.NotOnlineImage localNotOnlineImage = new im_msg_body.NotOnlineImage();
    for (;;)
    {
      try
      {
        PicFowardInfo localPicFowardInfo = (PicFowardInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (paramPicUpReq != null)
        {
          localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8(paramPicUpReq.fileName));
          localNotOnlineImage.file_len.set((int)paramPicUpReq.fileSize);
          localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(paramPicUpReq.md5));
          localNotOnlineImage.pic_height.set(paramPicUpReq.height);
          localNotOnlineImage.pic_width.set(paramPicUpReq.width);
          PBUInt32Field localPBUInt32Field = localNotOnlineImage.original;
          if (paramPicUpReq.isRaw) {
            i = 1;
          }
          localPBUInt32Field.set(i);
          if (paramC2CPicUpResp != null)
          {
            if (paramC2CPicUpResp.mUuid != null) {
              localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8(paramC2CPicUpResp.mUuid));
            }
            if (paramC2CPicUpResp.mResid != null) {
              localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8(paramC2CPicUpResp.mResid));
            }
            localNotOnlineImage.img_type.set(localPicFowardInfo.a.m);
            localNotOnlineImage.biz_type.set(4);
            localNotOnlineImage.uint32_thumb_width.set(localPicFowardInfo.a.e);
            localNotOnlineImage.uint32_thumb_height.set(localPicFowardInfo.a.f);
            Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] OK, " + a(localNotOnlineImage));
            return localNotOnlineImage;
          }
        }
        else
        {
          localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8("bad"));
          localNotOnlineImage.file_len.set(0);
          localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
          localNotOnlineImage.pic_height.set(localPicFowardInfo.a.k);
          localNotOnlineImage.pic_width.set(localPicFowardInfo.a.j);
          localNotOnlineImage.original.set(0);
          continue;
        }
        localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8("bad"));
      }
      catch (Exception paramPicUpReq)
      {
        Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] failed, Exception" + paramPicUpReq.toString());
        return null;
      }
      localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8("bad"));
    }
  }
  
  im_msg_body.NotOnlineImage a(im_msg_body.CustomFace paramCustomFace)
  {
    im_msg_body.NotOnlineImage localNotOnlineImage = new im_msg_body.NotOnlineImage();
    try
    {
      localNotOnlineImage.uint32_file_id.set(paramCustomFace.uint32_file_id.get());
      localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8("BADBADBAD"));
      Object localObject = new StringBuilder();
      long l = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = (1L + l);
      localObject = l + "BADBADBAD" + this.jdField_a_of_type_JavaUtilRandom.nextInt();
      localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8(paramCustomFace.str_file_path.get()));
      localNotOnlineImage.file_len.set(paramCustomFace.uint32_size.get());
      localNotOnlineImage.pic_md5.set(paramCustomFace.bytes_md5.get());
      localNotOnlineImage.pic_height.set(paramCustomFace.uint32_height.get());
      localNotOnlineImage.pic_width.set(paramCustomFace.uint32_width.get());
      localNotOnlineImage.original.set(paramCustomFace.uint32_origin.get());
      localNotOnlineImage.img_type.set(paramCustomFace.image_type.get());
      localNotOnlineImage.biz_type.set(4);
      localNotOnlineImage.uint32_thumb_width.set(paramCustomFace.uint32_thumb_width.get());
      localNotOnlineImage.uint32_thumb_height.set(paramCustomFace.uint32_thumb_height.get());
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "OK, " + a(localNotOnlineImage));
      return localNotOnlineImage;
    }
    catch (Exception paramCustomFace)
    {
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "Failed, Exception" + paramCustomFace.toString());
    }
    return null;
  }
  
  void a()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    int j = a();
    PicResult localPicResult = new PicResult();
    localPicResult.jdField_a_of_type_Int = 0;
    localPicResult.jdField_a_of_type_JavaLangObject = Integer.valueOf(i - j);
    this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator$MultiPicsUploadTask.a(localPicResult);
  }
  
  void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator$MultiPicsUploadTask.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.multipic.MultiPicsBaseClass
 * JD-Core Version:    0.7.0.1
 */