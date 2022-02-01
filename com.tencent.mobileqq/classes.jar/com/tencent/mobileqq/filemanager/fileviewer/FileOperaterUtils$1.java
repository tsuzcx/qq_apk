package com.tencent.mobileqq.filemanager.fileviewer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.recreate.IFModel;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class FileOperaterUtils$1
  implements View.OnClickListener
{
  FileOperaterUtils$1(String paramString, IFileBrowser paramIFileBrowser, long paramLong) {}
  
  public void onClick(View paramView)
  {
    try
    {
      Object localObject = new FileOperaterUtils.1.1(this);
      IFModel localIFModel = FileModel.a(this.a);
      if (localIFModel == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("error. get filemodel null, filepath[ ");
          ((StringBuilder)localObject).append(this.a);
          ((StringBuilder)localObject).append("]");
          QLog.w("FileOperaterUtils", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if (localIFModel.a(false))
      {
        if (!NetworkUtil.isNetSupportHw(BaseApplicationImpl.getContext())) {
          FMToastUtil.a(2131890731);
        } else if (FreeWifiHelper.a(this.b.getActivity(), 5, new FileOperaterUtils.1.2(this, (FMDialogUtil.FMDialogInterface)localObject))) {
          FMDialogUtil.a(this.b.getActivity(), 2131889584, 2131889587, (FMDialogUtil.FMDialogInterface)localObject);
        }
      }
      else {
        ((FMDialogUtil.FMDialogInterface)localObject).a();
      }
    }
    catch (Exception localException)
    {
      label149:
      break label149;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.1
 * JD-Core Version:    0.7.0.1
 */