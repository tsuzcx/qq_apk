package com.tencent.richmediabrowser.model.pic;

import android.os.Parcelable.Creator;
import com.tencent.richmediabrowser.model.RichMediaBaseData;

public class PictureData
  extends RichMediaBaseData
{
  public static final Parcelable.Creator<RichMediaBaseData> CREATOR = new PictureData.1();
  public int errorCode;
  public boolean isDownloadSuccess;
  
  public int getType()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.model.pic.PictureData
 * JD-Core Version:    0.7.0.1
 */