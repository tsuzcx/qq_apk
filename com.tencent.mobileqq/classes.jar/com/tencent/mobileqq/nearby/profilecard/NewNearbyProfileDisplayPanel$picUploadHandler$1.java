package com.tencent.mobileqq.nearby.profilecard;

import android.os.Message;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/nearby/profilecard/NewNearbyProfileDisplayPanel$picUploadHandler$1", "Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NewNearbyProfileDisplayPanel$picUploadHandler$1
  extends TransProcessorHandler
{
  public void handleMessage(@NotNull Message paramMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramMessage, "msg");
    Object localObject = paramMessage.obj;
    if (localObject != null)
    {
      localObject = (FileMsg)localObject;
      int i = paramMessage.what;
      if (i != 1003)
      {
        if (i != 1005) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("NewNearbyProfileDisplay", 2, "Q.nearby_people_card..mPicUploadHandler.handleMessage(), upload fail.");
        }
        paramMessage = this.a.e;
        paramMessage.showToast(HardCodeUtil.a(2131905158));
        if (NewNearbyProfileDisplayPanel.h(this.a).isEmpty()) {
          paramMessage.dismissWaittingDialog();
        } else {
          NewNearbyProfileDisplayPanel.j(this.a);
        }
        NewNearbyProfileDisplayPanel.a(this.a, (PicInfo)null);
        return;
      }
      if (((FileMsg)localObject).fileType == 8)
      {
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("Q.nearby_people_card..mPicUploadHandler.handleMessage(), upload success. photo_id = ");
          paramMessage.append(NearbyPeoplePhotoUploadProcessor.mPhotoId);
          QLog.i("NewNearbyProfileDisplay", 2, paramMessage.toString());
        }
        paramMessage = NewNearbyProfileDisplayPanel.f(this.a);
        if (paramMessage != null)
        {
          NewNearbyProfileDisplayPanel.a(this.a, (PicInfo)null);
          paramMessage.a = NearbyPeoplePhotoUploadProcessor.mPhotoId;
          NewNearbyProfileDisplayPanel.g(this.a).add(paramMessage);
          if (NewNearbyProfileDisplayPanel.h(this.a).isEmpty())
          {
            NewNearbyProfileDisplayPanel.i(this.a);
            return;
          }
          NewNearbyProfileDisplayPanel.j(this.a);
        }
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.transfile.FileMsg");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NewNearbyProfileDisplayPanel.picUploadHandler.1
 * JD-Core Version:    0.7.0.1
 */