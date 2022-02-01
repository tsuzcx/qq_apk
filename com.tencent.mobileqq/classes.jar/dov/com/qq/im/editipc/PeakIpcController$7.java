package dov.com.qq.im.editipc;

import android.os.Bundle;
import dov.com.qq.im.ae.util.AEQLog;
import eipc.EIPCModule;
import eipc.EIPCResult;

final class PeakIpcController$7
  extends EIPCModule
{
  PeakIpcController$7(String paramString1, String paramString2, PeakIpcController.IUploadArkVideoCallback paramIUploadArkVideoCallback)
  {
    super(paramString1);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null) {}
    do
    {
      do
      {
        return null;
        if (!"action_upload_ark_video_progress_update".equals(paramString)) {
          break;
        }
      } while (!paramBundle.containsKey("key_upload_ark_video_progress"));
      paramInt = paramBundle.getInt("key_upload_ark_video_progress");
      AEQLog.a("PeakIpcController", this.jdField_a_of_type_JavaLangString + " uploadArkVideo progress=" + paramInt);
    } while (this.jdField_a_of_type_DovComQqImEditipcPeakIpcController$IUploadArkVideoCallback == null);
    this.jdField_a_of_type_DovComQqImEditipcPeakIpcController$IUploadArkVideoCallback.a(paramInt);
    return null;
    if ("action_upload_ark_video_success".equals(paramString)) {
      if (!paramBundle.containsKey("key_upload_ark_video_download_url")) {
        break label264;
      }
    }
    label264:
    for (paramString = paramBundle.getString("key_upload_ark_video_download_url");; paramString = null)
    {
      AEQLog.b("PeakIpcController", this.jdField_a_of_type_JavaLangString + " uploadArkVideo SUCCESS: videoDownUrl=" + paramString);
      if (this.jdField_a_of_type_DovComQqImEditipcPeakIpcController$IUploadArkVideoCallback == null) {
        break;
      }
      this.jdField_a_of_type_DovComQqImEditipcPeakIpcController$IUploadArkVideoCallback.a(paramString);
      return null;
      if ("action_upload_ark_video_fail".equals(paramString))
      {
        AEQLog.b("PeakIpcController", this.jdField_a_of_type_JavaLangString + " uploadArkVideo FAIL");
        if (this.jdField_a_of_type_DovComQqImEditipcPeakIpcController$IUploadArkVideoCallback == null) {
          break;
        }
        this.jdField_a_of_type_DovComQqImEditipcPeakIpcController$IUploadArkVideoCallback.a();
        return null;
      }
      if (!"action_upload_ark_video_cancel".equals(paramString)) {
        break;
      }
      AEQLog.b("PeakIpcController", this.jdField_a_of_type_JavaLangString + " uploadArkVideo CANCEL");
      if (this.jdField_a_of_type_DovComQqImEditipcPeakIpcController$IUploadArkVideoCallback == null) {
        break;
      }
      this.jdField_a_of_type_DovComQqImEditipcPeakIpcController$IUploadArkVideoCallback.b();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.editipc.PeakIpcController.7
 * JD-Core Version:    0.7.0.1
 */