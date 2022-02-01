package com.tencent.mobileqq.emoticonview.api;

import android.content.Context;
import android.os.Parcelable;
import android.widget.EditText;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.net.URL;
import mqq.app.AppRuntime;

@QAPI(process={""})
public abstract interface IHotPicSearchService
  extends QRouteApi
{
  public abstract int getReportFromType();
  
  public abstract URL getURL(String paramString);
  
  public abstract boolean isRichTextLastTab(Context paramContext, String paramString);
  
  public abstract void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable1, Parcelable paramParcelable2, String paramString, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IHotPicSearchService
 * JD-Core Version:    0.7.0.1
 */