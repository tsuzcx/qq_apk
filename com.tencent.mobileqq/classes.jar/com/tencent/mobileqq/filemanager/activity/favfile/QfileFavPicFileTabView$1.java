package com.tencent.mobileqq.filemanager.activity.favfile;

import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;

class QfileFavPicFileTabView$1
  implements QfileFavImageExpandableListAdapter.IAdapterCallBack
{
  QfileFavPicFileTabView$1(QfileFavPicFileTabView paramQfileFavPicFileTabView) {}
  
  public View.OnClickListener a(TextView paramTextView)
  {
    this.a.getMoreFileRecord();
    return null;
  }
  
  public boolean a()
  {
    return this.a.h();
  }
  
  public boolean a(FavFileInfo paramFavFileInfo)
  {
    return false;
  }
  
  public boolean b()
  {
    return this.a.q();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavPicFileTabView.1
 * JD-Core Version:    0.7.0.1
 */