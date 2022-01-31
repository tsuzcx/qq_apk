package com.tencent.mobileqq.config.business;

import alzw;
import amdi;
import atlj;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.ArrayList;

public final class OnlineStatusBean$1
  implements Runnable
{
  public void run()
  {
    ArrayList localArrayList = ((amdi)alzw.a().a(578)).a();
    int i = 0;
    while (i < localArrayList.size())
    {
      if (((atlj)localArrayList.get(i)).a == 1)
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        URLDrawable.getDrawable(((atlj)localArrayList.get(i)).b, localURLDrawableOptions).startDownload();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OnlineStatusBean.1
 * JD-Core Version:    0.7.0.1
 */