package com.tencent.mobileqq.pic.operator.multipic;

import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.SigInfo;
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
  private volatile long a;
  private Random b = new Random(System.currentTimeMillis());
  public String e;
  public String f;
  protected WeakReference<AppInterface> g;
  ArrayList<PicResult> h;
  List<PicFowardInfo> i;
  MultiPicsOperator.MultiPicsUploadTask j;
  
  public MultiPicsBaseClass(MultiPicsOperator.MultiPicsUploadTask paramMultiPicsUploadTask, WeakReference<AppInterface> paramWeakReference)
  {
    this.j = paramMultiPicsUploadTask;
    this.h = paramMultiPicsUploadTask.d;
    this.i = paramMultiPicsUploadTask.e;
    this.e = paramMultiPicsUploadTask.a;
    this.f = paramMultiPicsUploadTask.b;
    this.g = paramWeakReference;
  }
  
  im_msg_body.CustomFace a(RichProto.RichProtoReq.PicUpReq paramPicUpReq, RichProto.RichProtoResp.GroupPicUpResp paramGroupPicUpResp, int paramInt)
  {
    Object localObject1 = new im_msg_body.CustomFace();
    try
    {
      localObject2 = (PicFowardInfo)this.i.get(paramInt);
      int k = 0;
      if (paramGroupPicUpResp != null)
      {
        ((im_msg_body.CustomFace)localObject1).uint32_file_id.set((int)paramGroupPicUpResp.groupFileID);
        if ((paramGroupPicUpResp.mIpList != null) && (paramGroupPicUpResp.mIpList.size() > 0))
        {
          paramGroupPicUpResp = (ServerAddr)paramGroupPicUpResp.mIpList.get(0);
          ((im_msg_body.CustomFace)localObject1).uint32_server_ip.set(GroupPicUploadProcessor.ipToLong(paramGroupPicUpResp.mIp));
          ((im_msg_body.CustomFace)localObject1).uint32_server_port.set(paramGroupPicUpResp.port);
        }
      }
      else
      {
        ((im_msg_body.CustomFace)localObject1).uint32_file_id.set(0);
      }
      ((im_msg_body.CustomFace)localObject1).uint32_file_type.set(Integer.valueOf(66).intValue());
      ((im_msg_body.CustomFace)localObject1).uint32_useful.set(1);
      SigInfo.fillCustomFaceSessionKey((AppInterface)this.g.get(), (im_msg_body.CustomFace)localObject1);
      if (paramPicUpReq != null)
      {
        ((im_msg_body.CustomFace)localObject1).bytes_md5.set(ByteStringMicro.copyFrom(paramPicUpReq.md5));
        ((im_msg_body.CustomFace)localObject1).str_file_path.set(paramPicUpReq.fileName);
        paramGroupPicUpResp = ((im_msg_body.CustomFace)localObject1).uint32_origin;
        if (paramPicUpReq.isRaw) {
          k = 1;
        }
        paramGroupPicUpResp.set(k);
        ((im_msg_body.CustomFace)localObject1).uint32_width.set(paramPicUpReq.width);
        ((im_msg_body.CustomFace)localObject1).uint32_height.set(paramPicUpReq.height);
        ((im_msg_body.CustomFace)localObject1).uint32_size.set((int)paramPicUpReq.fileSize);
      }
      else
      {
        ((im_msg_body.CustomFace)localObject1).bytes_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
        ((im_msg_body.CustomFace)localObject1).str_file_path.set("bad");
        ((im_msg_body.CustomFace)localObject1).uint32_origin.set(0);
        ((im_msg_body.CustomFace)localObject1).uint32_width.set(((PicFowardInfo)localObject2).b.C);
        ((im_msg_body.CustomFace)localObject1).uint32_height.set(((PicFowardInfo)localObject2).b.D);
        ((im_msg_body.CustomFace)localObject1).uint32_size.set(0);
      }
      ((im_msg_body.CustomFace)localObject1).biz_type.set(4);
      ((im_msg_body.CustomFace)localObject1).uint32_source.set(104);
      ((im_msg_body.CustomFace)localObject1).uint32_thumb_width.set(((PicFowardInfo)localObject2).b.p);
      ((im_msg_body.CustomFace)localObject1).uint32_thumb_height.set(((PicFowardInfo)localObject2).b.q);
      ((im_msg_body.CustomFace)localObject1).image_type.set(((PicFowardInfo)localObject2).b.G);
      paramPicUpReq = this.f;
      paramGroupPicUpResp = this.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("] OK, ");
      ((StringBuilder)localObject2).append(b((im_msg_body.CustomFace)localObject1));
      Logger.a(paramPicUpReq, paramGroupPicUpResp, "uploadForwardMultiMsgPics.createCustomFace", ((StringBuilder)localObject2).toString());
      return localObject1;
    }
    catch (Exception paramPicUpReq)
    {
      paramGroupPicUpResp = this.f;
      localObject1 = this.e;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("] failed, Exception, ");
      ((StringBuilder)localObject2).append(paramPicUpReq.toString());
      Logger.b(paramGroupPicUpResp, (String)localObject1, "uploadForwardMultiMsgPics.createCustomFace", ((StringBuilder)localObject2).toString());
    }
    return null;
  }
  
  im_msg_body.CustomFace a(im_msg_body.NotOnlineImage paramNotOnlineImage)
  {
    Object localObject = new im_msg_body.CustomFace();
    try
    {
      ((im_msg_body.CustomFace)localObject).uint32_file_id.set(paramNotOnlineImage.uint32_file_id.get());
      ((im_msg_body.CustomFace)localObject).uint32_file_type.set(Integer.valueOf(66).intValue());
      ((im_msg_body.CustomFace)localObject).uint32_useful.set(1);
      SigInfo.fillCustomFaceSessionKey((AppInterface)this.g.get(), (im_msg_body.CustomFace)localObject);
      ((im_msg_body.CustomFace)localObject).bytes_md5.set(ByteStringMicro.copyFrom(paramNotOnlineImage.pic_md5.get().toByteArray()));
      if (paramNotOnlineImage.res_id.has()) {
        ((im_msg_body.CustomFace)localObject).str_file_path.set(paramNotOnlineImage.res_id.get().toStringUtf8());
      } else if (paramNotOnlineImage.download_path.has()) {
        ((im_msg_body.CustomFace)localObject).str_file_path.set(paramNotOnlineImage.download_path.get().toStringUtf8());
      }
      ((im_msg_body.CustomFace)localObject).uint32_origin.set(paramNotOnlineImage.original.get());
      ((im_msg_body.CustomFace)localObject).biz_type.set(4);
      ((im_msg_body.CustomFace)localObject).uint32_source.set(104);
      ((im_msg_body.CustomFace)localObject).uint32_width.set(paramNotOnlineImage.pic_width.get());
      ((im_msg_body.CustomFace)localObject).uint32_height.set(paramNotOnlineImage.pic_height.get());
      ((im_msg_body.CustomFace)localObject).uint32_size.set(paramNotOnlineImage.file_len.get());
      ((im_msg_body.CustomFace)localObject).uint32_thumb_width.set(paramNotOnlineImage.uint32_thumb_width.get());
      ((im_msg_body.CustomFace)localObject).uint32_thumb_height.set(paramNotOnlineImage.uint32_thumb_height.get());
      ((im_msg_body.CustomFace)localObject).image_type.set(paramNotOnlineImage.img_type.get());
      Logger.a(this.f, this.e, "uploadForwardMultiMsgPics.convert2CustomFace", b((im_msg_body.CustomFace)localObject));
      return localObject;
    }
    catch (Exception paramNotOnlineImage)
    {
      localObject = this.f;
      String str = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception, ");
      localStringBuilder.append(paramNotOnlineImage.toString());
      Logger.b((String)localObject, str, "uploadForwardMultiMsgPics.convert2CustomFace", localStringBuilder.toString());
    }
    return null;
  }
  
  im_msg_body.NotOnlineImage a(RichProto.RichProtoReq.PicUpReq paramPicUpReq, RichProto.RichProtoResp.C2CPicUpResp paramC2CPicUpResp, int paramInt)
  {
    Object localObject1 = new im_msg_body.NotOnlineImage();
    for (;;)
    {
      try
      {
        localObject2 = (PicFowardInfo)this.i.get(paramInt);
        k = 1;
        if (paramPicUpReq != null)
        {
          ((im_msg_body.NotOnlineImage)localObject1).file_path.set(ByteStringMicro.copyFromUtf8(paramPicUpReq.fileName));
          ((im_msg_body.NotOnlineImage)localObject1).file_len.set((int)paramPicUpReq.fileSize);
          ((im_msg_body.NotOnlineImage)localObject1).pic_md5.set(ByteStringMicro.copyFrom(paramPicUpReq.md5));
          ((im_msg_body.NotOnlineImage)localObject1).pic_height.set(paramPicUpReq.height);
          ((im_msg_body.NotOnlineImage)localObject1).pic_width.set(paramPicUpReq.width);
          PBUInt32Field localPBUInt32Field = ((im_msg_body.NotOnlineImage)localObject1).original;
          if (!paramPicUpReq.isRaw) {
            break label493;
          }
          localPBUInt32Field.set(k);
        }
        else
        {
          ((im_msg_body.NotOnlineImage)localObject1).file_path.set(ByteStringMicro.copyFromUtf8("bad"));
          ((im_msg_body.NotOnlineImage)localObject1).file_len.set(0);
          ((im_msg_body.NotOnlineImage)localObject1).pic_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
          ((im_msg_body.NotOnlineImage)localObject1).pic_height.set(((PicFowardInfo)localObject2).b.D);
          ((im_msg_body.NotOnlineImage)localObject1).pic_width.set(((PicFowardInfo)localObject2).b.C);
          ((im_msg_body.NotOnlineImage)localObject1).original.set(0);
        }
        if (paramC2CPicUpResp != null)
        {
          if (paramC2CPicUpResp.mUuid != null) {
            ((im_msg_body.NotOnlineImage)localObject1).download_path.set(ByteStringMicro.copyFromUtf8(paramC2CPicUpResp.mUuid));
          }
          if (paramC2CPicUpResp.mResid != null) {
            ((im_msg_body.NotOnlineImage)localObject1).res_id.set(ByteStringMicro.copyFromUtf8(paramC2CPicUpResp.mResid));
          }
        }
        else
        {
          ((im_msg_body.NotOnlineImage)localObject1).download_path.set(ByteStringMicro.copyFromUtf8("bad"));
          ((im_msg_body.NotOnlineImage)localObject1).res_id.set(ByteStringMicro.copyFromUtf8("bad"));
        }
        ((im_msg_body.NotOnlineImage)localObject1).img_type.set(((PicFowardInfo)localObject2).b.G);
        ((im_msg_body.NotOnlineImage)localObject1).biz_type.set(4);
        ((im_msg_body.NotOnlineImage)localObject1).uint32_thumb_width.set(((PicFowardInfo)localObject2).b.p);
        ((im_msg_body.NotOnlineImage)localObject1).uint32_thumb_height.set(((PicFowardInfo)localObject2).b.q);
        paramPicUpReq = this.f;
        paramC2CPicUpResp = this.e;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append("] OK, ");
        ((StringBuilder)localObject2).append(b((im_msg_body.NotOnlineImage)localObject1));
        Logger.a(paramPicUpReq, paramC2CPicUpResp, "uploadForwardMultiMsgPics.createNotOnlineImage", ((StringBuilder)localObject2).toString());
        return localObject1;
      }
      catch (Exception paramPicUpReq)
      {
        paramC2CPicUpResp = this.f;
        localObject1 = this.e;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append("] failed, Exception");
        ((StringBuilder)localObject2).append(paramPicUpReq.toString());
        Logger.a(paramC2CPicUpResp, (String)localObject1, "uploadForwardMultiMsgPics.createNotOnlineImage", ((StringBuilder)localObject2).toString());
        return null;
      }
      label493:
      int k = 0;
    }
  }
  
  im_msg_body.NotOnlineImage a(im_msg_body.CustomFace paramCustomFace)
  {
    Object localObject1 = new im_msg_body.NotOnlineImage();
    try
    {
      ((im_msg_body.NotOnlineImage)localObject1).uint32_file_id.set(paramCustomFace.uint32_file_id.get());
      ((im_msg_body.NotOnlineImage)localObject1).download_path.set(ByteStringMicro.copyFromUtf8("BADBADBAD"));
      localObject2 = new StringBuilder();
      long l = this.a;
      this.a = (1L + l);
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append("BADBADBAD");
      ((StringBuilder)localObject2).append(this.b.nextInt());
      localObject2 = ((StringBuilder)localObject2).toString();
      ((im_msg_body.NotOnlineImage)localObject1).res_id.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      ((im_msg_body.NotOnlineImage)localObject1).file_path.set(ByteStringMicro.copyFromUtf8(paramCustomFace.str_file_path.get()));
      ((im_msg_body.NotOnlineImage)localObject1).file_len.set(paramCustomFace.uint32_size.get());
      ((im_msg_body.NotOnlineImage)localObject1).pic_md5.set(paramCustomFace.bytes_md5.get());
      ((im_msg_body.NotOnlineImage)localObject1).pic_height.set(paramCustomFace.uint32_height.get());
      ((im_msg_body.NotOnlineImage)localObject1).pic_width.set(paramCustomFace.uint32_width.get());
      ((im_msg_body.NotOnlineImage)localObject1).original.set(paramCustomFace.uint32_origin.get());
      ((im_msg_body.NotOnlineImage)localObject1).img_type.set(paramCustomFace.image_type.get());
      ((im_msg_body.NotOnlineImage)localObject1).biz_type.set(4);
      ((im_msg_body.NotOnlineImage)localObject1).uint32_thumb_width.set(paramCustomFace.uint32_thumb_width.get());
      ((im_msg_body.NotOnlineImage)localObject1).uint32_thumb_height.set(paramCustomFace.uint32_thumb_height.get());
      paramCustomFace = this.f;
      localObject2 = this.e;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OK, ");
      localStringBuilder.append(b((im_msg_body.NotOnlineImage)localObject1));
      Logger.a(paramCustomFace, (String)localObject2, "uploadForwardMultiMsgPics.createNotOnlineImage", localStringBuilder.toString());
      return localObject1;
    }
    catch (Exception paramCustomFace)
    {
      localObject1 = this.f;
      Object localObject2 = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed, Exception");
      localStringBuilder.append(paramCustomFace.toString());
      Logger.a((String)localObject1, (String)localObject2, "uploadForwardMultiMsgPics.createNotOnlineImage", localStringBuilder.toString());
    }
    return null;
  }
  
  void a()
  {
    int k = this.i.size();
    int m = c();
    PicResult localPicResult = new PicResult();
    localPicResult.a = 0;
    localPicResult.d = Integer.valueOf(k - m);
    this.j.a(localPicResult);
  }
  
  String b(im_msg_body.CustomFace paramCustomFace)
  {
    if ((QLog.isColorLevel()) && (paramCustomFace != null))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[CustomFace]uint32_server_ip:");
      localStringBuilder2.append(paramCustomFace.uint32_server_ip.get());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",uint32_server_port:");
      localStringBuilder2.append(paramCustomFace.uint32_server_port.get());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",uint32_file_id:");
      localStringBuilder2.append(paramCustomFace.uint32_file_id.get());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",bytes_md5:");
      localStringBuilder2.append(HexUtil.bytes2HexStr(paramCustomFace.bytes_md5.get().toByteArray()));
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",str_file_path:");
      localStringBuilder2.append(paramCustomFace.str_file_path.get());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",uint32_origin:");
      localStringBuilder2.append(paramCustomFace.uint32_origin.get());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",uint32_width:");
      localStringBuilder2.append(paramCustomFace.uint32_width.get());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",uint32_height:");
      localStringBuilder2.append(paramCustomFace.uint32_height.get());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",uint32_height:");
      localStringBuilder2.append(paramCustomFace.uint32_height.get());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",image_type:");
      localStringBuilder2.append(paramCustomFace.image_type.get());
      localStringBuilder1.append(localStringBuilder2.toString());
      return localStringBuilder1.toString();
    }
    return "";
  }
  
  String b(im_msg_body.NotOnlineImage paramNotOnlineImage)
  {
    if ((QLog.isColorLevel()) && (paramNotOnlineImage != null))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[NotOnlineImage]file_path:");
      localStringBuilder2.append(paramNotOnlineImage.file_path.get().toStringUtf8());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",file_len:");
      localStringBuilder2.append(paramNotOnlineImage.file_len.get());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",download_path:");
      localStringBuilder2.append(paramNotOnlineImage.download_path.get().toStringUtf8());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",res_id:");
      localStringBuilder2.append(paramNotOnlineImage.res_id.get().toStringUtf8());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",pic_md5:");
      localStringBuilder2.append(HexUtil.bytes2HexStr(paramNotOnlineImage.pic_md5.get().toByteArray()));
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",pic_height:");
      localStringBuilder2.append(paramNotOnlineImage.pic_height.get());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",pic_width:");
      localStringBuilder2.append(paramNotOnlineImage.pic_width.get());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",original:");
      localStringBuilder2.append(paramNotOnlineImage.original.get());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",img_type:");
      localStringBuilder2.append(paramNotOnlineImage.img_type.get());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",uint32_file_id:");
      localStringBuilder2.append(paramNotOnlineImage.uint32_file_id.get());
      localStringBuilder1.append(localStringBuilder2.toString());
      return localStringBuilder1.toString();
    }
    return "";
  }
  
  void b()
  {
    this.j.a();
  }
  
  int c()
  {
    ArrayList localArrayList = this.h;
    int k = 0;
    try
    {
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext()) {
        if (((PicResult)localIterator.next()).a == -2) {
          k += 1;
        }
      }
      return k;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.multipic.MultiPicsBaseClass
 * JD-Core Version:    0.7.0.1
 */