package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class FileOperaterUtils$8
  implements View.OnClickListener
{
  FileOperaterUtils$8(FileManagerEntity paramFileManagerEntity, IFileBrowser paramIFileBrowser) {}
  
  public void onClick(View paramView)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(localQQAppInterface, this.a);
      if (localTroopFileStatusInfo.r != null) {
        if (NetworkUtil.getSystemNetwork(this.b.getActivity()) == 0)
        {
          TroopFileError.a(this.b.getActivity(), this.b.getActivity().getString(2131895389));
        }
        else
        {
          TroopFileError.a(this.b.getActivity(), this.b.getActivity().getString(2131889761), 0);
          TroopFileTransferManager.a(localQQAppInterface, this.a.TroopUin).b(localTroopFileStatusInfo.r, localTroopFileStatusInfo.t, localTroopFileStatusInfo.i, localTroopFileStatusInfo.u);
        }
      }
    }
    catch (Exception localException)
    {
      label130:
      break label130;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.8
 * JD-Core Version:    0.7.0.1
 */