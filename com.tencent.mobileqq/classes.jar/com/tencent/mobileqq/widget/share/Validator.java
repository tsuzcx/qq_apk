package com.tencent.mobileqq.widget.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.util.Iterator;
import java.util.List;

public class Validator
{
  private ShareActionSheetV2 a;
  private boolean b = false;
  
  public Validator(ShareActionSheetV2 paramShareActionSheetV2)
  {
    this.a = paramShareActionSheetV2;
  }
  
  private void a(String paramString)
  {
    new Handler(Looper.getMainLooper()).post(new Validator.1(this, paramString));
  }
  
  private boolean b()
  {
    List[] arrayOfList = this.a.b();
    int i = 0;
    while (i < arrayOfList.length)
    {
      Iterator localIterator = arrayOfList[i].iterator();
      while (localIterator.hasNext()) {
        if (!((ShareActionSheetBuilder.ActionSheetItem)localIterator.next()).isValidCreate()) {
          return false;
        }
      }
      i += 1;
    }
    return true;
  }
  
  private boolean c()
  {
    List[] arrayOfList = this.a.b();
    int i = 0;
    while (i < arrayOfList.length)
    {
      Iterator localIterator = arrayOfList[i].iterator();
      while (localIterator.hasNext()) {
        if (!((ShareActionSheetBuilder.ActionSheetItem)localIterator.next()).isValidLabel()) {
          return false;
        }
      }
      i += 1;
    }
    return true;
  }
  
  private boolean d()
  {
    List[] arrayOfList = this.a.b();
    int i = 0;
    while (i < arrayOfList.length)
    {
      Iterator localIterator = arrayOfList[i].iterator();
      while (localIterator.hasNext()) {
        if (!((ShareActionSheetBuilder.ActionSheetItem)localIterator.next()).isValidIcon()) {
          return false;
        }
      }
      i += 1;
    }
    return true;
  }
  
  private boolean e()
  {
    Object localObject = this.a.a;
    if ((localObject instanceof Activity))
    {
      localObject = ((Activity)localObject).getIntent();
      if (!TextUtils.isEmpty(((Intent)localObject).getStringExtra("big_brother_source_key"))) {
        return true;
      }
      return TextUtils.isEmpty(((Intent)localObject).getStringExtra("url")) ^ true;
    }
    return false;
  }
  
  public boolean a()
  {
    boolean bool2 = this.b;
    boolean bool1 = true;
    if (!bool2) {
      return true;
    }
    if (!e())
    {
      a("share component no biz id");
      bool1 = false;
    }
    if (!d())
    {
      a("share component icon invalid");
      bool1 = false;
    }
    if (!c())
    {
      a("share component label invalid");
      bool1 = false;
    }
    if (!b())
    {
      a("share component item invalid");
      bool1 = false;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.Validator
 * JD-Core Version:    0.7.0.1
 */