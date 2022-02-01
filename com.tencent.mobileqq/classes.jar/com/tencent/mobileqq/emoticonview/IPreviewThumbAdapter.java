package com.tencent.mobileqq.emoticonview;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import java.util.ArrayList;

public abstract interface IPreviewThumbAdapter
  extends AdapterView.OnItemClickListener, ListAdapter
{
  public abstract String getCurrentPath();
  
  public abstract ArrayList<String> getDataList();
  
  public abstract void notifyDataSetChanged();
  
  public abstract void setCurrentPath(String paramString);
  
  public abstract void setData(ArrayList<String> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.IPreviewThumbAdapter
 * JD-Core Version:    0.7.0.1
 */