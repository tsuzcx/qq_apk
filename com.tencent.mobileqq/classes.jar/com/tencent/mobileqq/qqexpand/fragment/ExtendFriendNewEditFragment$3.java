package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qqexpand.widget.PhotoWallListView.PhotoPath;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ExtendFriendNewEditFragment$3
  implements Runnable
{
  ExtendFriendNewEditFragment$3(ExtendFriendNewEditFragment paramExtendFriendNewEditFragment) {}
  
  public void run()
  {
    if ((ExtendFriendNewEditFragment.d(this.this$0) != null) && (ExtendFriendNewEditFragment.e(this.this$0) >= 0) && (ExtendFriendNewEditFragment.d(this.this$0).size() > ExtendFriendNewEditFragment.e(this.this$0)))
    {
      String str = ((PhotoWallListView.PhotoPath)ExtendFriendNewEditFragment.d(this.this$0).get(ExtendFriendNewEditFragment.e(this.this$0))).b;
      Object localObject = new CompressInfo(str, 0);
      ((CompressInfo)localObject).o = 0;
      ((ICompressOperator)QRoute.api(ICompressOperator.class)).start((CompressInfo)localObject);
      if (!StringUtil.isEmpty(((CompressInfo)localObject).l)) {
        str = ((CompressInfo)localObject).l;
      }
      if (!StringUtil.isEmpty(str))
      {
        localObject = new TransferRequest();
        ((TransferRequest)localObject).mIsUp = true;
        ((TransferRequest)localObject).mLocalPath = str;
        ((TransferRequest)localObject).mUniseq = System.currentTimeMillis();
        ((TransferRequest)localObject).mFileType = 67;
        Bdh_extinfo.CommFileExtReq localCommFileExtReq = new Bdh_extinfo.CommFileExtReq();
        localCommFileExtReq.uint32_action_type.set(0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(ExtendFriendNewEditFragment.h(this.this$0));
        localStringBuilder.append("-");
        localStringBuilder.append(ExtendFriendNewEditFragment.a(this.this$0, str));
        localStringBuilder.append(".jpg");
        str = localStringBuilder.toString();
        localCommFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(str));
        ((TransferRequest)localObject).mExtentionInfo = localCommFileExtReq.toByteArray();
        ((ITransFileController)ExtendFriendNewEditFragment.i(this.this$0).getRuntimeService(ITransFileController.class)).transferAsync((TransferRequest)localObject);
        return;
      }
      QLog.e("ExtendFriendNewEditFragment", 1, "uploadTask uploadPath is null");
      this.this$0.a(1, "图片上传失败", true);
      return;
    }
    QLog.e("ExtendFriendNewEditFragment", 1, "uploadTask cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment.3
 * JD-Core Version:    0.7.0.1
 */