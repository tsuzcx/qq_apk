package com.tencent.mobileqq.filemanager.activity.favfile;

import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;

public abstract interface QfileFavImageExpandableListAdapter$IAdapterCallBack
{
  public abstract View.OnClickListener a(TextView paramTextView);
  
  public abstract boolean a();
  
  public abstract boolean a(FavFileInfo paramFavFileInfo);
  
  public abstract boolean b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavImageExpandableListAdapter.IAdapterCallBack
 * JD-Core Version:    0.7.0.1
 */