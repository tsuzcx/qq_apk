package com.tencent.mobileqq.filemanageraux.fileviewer.FileView;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.kwstudio.office.preview.TdsReaderView.OpenCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

final class LocalTdsViewManager$OpenCallbackImpl
  implements TdsReaderView.OpenCallback
{
  private final int jdField_a_of_type_Int;
  private final LocalTdsViewManager.LocalTdsViewManagerCallback jdField_a_of_type_ComTencentMobileqqFilemanagerauxFileviewerFileViewLocalTdsViewManager$LocalTdsViewManagerCallback;
  private final WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private final boolean jdField_a_of_type_Boolean;
  
  private LocalTdsViewManager$OpenCallbackImpl(Activity paramActivity, boolean paramBoolean, LocalTdsViewManager.LocalTdsViewManagerCallback paramLocalTdsViewManagerCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxFileviewerFileViewLocalTdsViewManager$LocalTdsViewManagerCallback = paramLocalTdsViewManagerCallback;
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {}
    for (int i = (int)paramActivity.getResources().getDimension(2131299166);; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public void onCallBackAction(Integer paramInteger, Object paramObject, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean) {
      QLog.i("TdsReaderView_LocalTdsViewManager", 1, "onCallBackAction actionType[" + paramInteger + "]");
    }
    Activity localActivity;
    do
    {
      do
      {
        return;
        localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      } while ((localActivity == null) || (localActivity.isFinishing()));
      if (paramInteger.intValue() != 1001) {
        break;
      }
    } while (paramBundle == null);
    paramBundle.putInt("result_", this.jdField_a_of_type_Int);
    return;
    localActivity.runOnUiThread(new LocalTdsViewManager.OpenCallbackImpl.1(this, paramInteger, paramObject, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.FileView.LocalTdsViewManager.OpenCallbackImpl
 * JD-Core Version:    0.7.0.1
 */