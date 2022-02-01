package com.tencent.mobileqq.filemanager.fileview;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.tbs.reader.TbsReaderView.ReaderCallback;

class LocalTbsViewManager$TbsFileReaderEventCallback
  implements TbsReaderView.ReaderCallback
{
  private final LocalTbsViewManager.LocalTbsViewManagerCallback b;
  private final Activity c;
  private final String d;
  
  public LocalTbsViewManager$TbsFileReaderEventCallback(LocalTbsViewManager paramLocalTbsViewManager, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback, Activity paramActivity, String paramString)
  {
    this.b = paramLocalTbsViewManagerCallback;
    this.c = paramActivity;
    this.d = paramString;
  }
  
  public void a(Object paramObject, String paramString, int paramInt)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof Bundle)) {
        return;
      }
      ((Bundle)paramObject).putInt(paramString, paramInt);
    }
  }
  
  public void a(Object paramObject, String paramString, boolean paramBoolean)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof Bundle)) {
        return;
      }
      ((Bundle)paramObject).putBoolean(paramString, paramBoolean);
    }
  }
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    int i = paramInteger.intValue();
    if (i != 12)
    {
      boolean bool = true;
      Object localObject;
      if (i != 19)
      {
        if (i != 5000)
        {
          if (i != 5045)
          {
            if (i != 5011) {
              if (i != 5012)
              {
                if (i != 5024)
                {
                  if (i == 5025) {
                    LocalTbsViewManager.a(this.a, false, false);
                  }
                }
                else
                {
                  localObject = this.b;
                  if (localObject != null) {
                    a(paramObject2, "is_bar_show", ((LocalTbsViewManager.LocalTbsViewManagerCallback)localObject).a() ^ true);
                  }
                }
              }
              else {
                this.a.a(paramObject1, this.d);
              }
            }
          }
          else {
            a(paramObject2, "TitleHeight", (int)this.c.getResources().getDimension(2131299920));
          }
        }
        else {
          a(paramObject2, "is_bar_animating", false);
        }
      }
      else if ((paramObject1 != null) && ((paramObject1 instanceof Integer)))
      {
        localObject = this.a;
        if (((Integer)paramObject1).intValue() != 0) {
          bool = false;
        }
        LocalTbsViewManager.a((LocalTbsViewManager)localObject, false, bool);
      }
    }
    else
    {
      this.a.a(paramObject1, this.c, this.b);
    }
    this.a.a(paramInteger.intValue(), this.b);
    if (paramInteger.intValue() == 6001) {
      this.a.a(this.c, paramObject1, paramObject2, this.d, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.TbsFileReaderEventCallback
 * JD-Core Version:    0.7.0.1
 */