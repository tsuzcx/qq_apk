package dov.com.qq.im.aeeditor.manage;

import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import dov.com.qq.im.ae.util.AEDownloader.DownloadListener;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;

class AEEditorResourceDownloader$5
  implements AEDownloader.DownloadListener
{
  AEEditorResourceDownloader$5(AEEditorResourceDownloader paramAEEditorResourceDownloader, AEEditorResourceDownloader.ResDownLoadListener paramResDownLoadListener, String paramString1, AEEditorDownloadResBean paramAEEditorDownloadResBean, String paramString2, String paramString3) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorResourceDownloader$ResDownLoadListener != null) {
      this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorResourceDownloader$ResDownLoadListener.a(paramInt);
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    boolean bool3 = false;
    if (paramNetResp == null)
    {
      if (this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorResourceDownloader$ResDownLoadListener != null) {
        this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorResourceDownloader$ResDownLoadListener.a(false);
      }
      this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorResourceDownloader.a(this.jdField_a_of_type_JavaLangString, false);
      return;
    }
    boolean bool1;
    boolean bool2;
    if (paramNetResp.mResult == 0)
    {
      bool1 = true;
      AEQLog.b(this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorResourceDownloader.c, "downLoadOneResInternal-onDownloadFinish---isSuccess=" + bool1 + ", id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId());
      bool2 = bool3;
      if (bool1)
      {
        String str = FileUtils.c(this.b);
        if ((str == null) || (!str.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))) {
          break label321;
        }
      }
    }
    for (;;)
    {
      try
      {
        bool2 = this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorResourceDownloader.a(this.b, this.c, this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId(), this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorResourceDownloader.a(bool1, paramNetResp.mErrCode, paramNetResp.reqCost, this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId());
        if (!bool2) {
          FileUtils.a(this.c);
        }
        FileUtils.e(this.b);
        AEQLog.b(this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorResourceDownloader.c, "downLoadOneResInternal-onDownloadFinish---REAL result=" + bool2 + ", id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId());
        if (this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorResourceDownloader$ResDownLoadListener != null) {
          this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorResourceDownloader$ResDownLoadListener.a(bool2);
        }
        this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorResourceDownloader.a(this.jdField_a_of_type_JavaLangString, bool2);
        return;
        bool1 = false;
      }
      catch (Exception localException)
      {
        AEQLog.a(this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorResourceDownloader.c, "downLoadOneResInternal-onDownloadFinish---unZipFile failed, id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId(), localException);
        localException.printStackTrace();
        bool2 = bool3;
        continue;
      }
      label321:
      AEQLog.d(this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorResourceDownloader.c, "downLoadOneResInternal-onDownloadFinish---MD5 check failed, id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId());
      bool2 = bool3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEEditorResourceDownloader.5
 * JD-Core Version:    0.7.0.1
 */