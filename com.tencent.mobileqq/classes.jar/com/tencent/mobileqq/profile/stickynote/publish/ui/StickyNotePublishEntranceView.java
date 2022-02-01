package com.tencent.mobileqq.profile.stickynote.publish.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import org.json.JSONObject;

public class StickyNotePublishEntranceView
  extends FrameLayout
{
  private Card a;
  private boolean b;
  private ViewGroup c;
  private URLImageView d;
  private URLImageView e;
  private TextView f;
  private Drawable g;
  private Drawable h;
  private String i;
  private String j;
  private int k = 1;
  
  public StickyNotePublishEntranceView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StickyNotePublishEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  protected String a(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      Card localCard = this.a;
      localObject = paramString;
      if (localCard != null)
      {
        localObject = getContext().getResources();
        if (localCard.shGender == 0) {
          localObject = ((Resources)localObject).getString(2131890667);
        } else if (localCard.shGender == 1) {
          localObject = ((Resources)localObject).getString(2131916580);
        } else {
          localObject = ((Resources)localObject).getString(2131916995);
        }
        localObject = paramString.replace("{TA}", (CharSequence)localObject);
      }
    }
    return localObject;
  }
  
  public void a()
  {
    String str = (String)VSConfigManager.a().a("sticky_note_publish_entrance_config", "");
    if (TextUtils.isEmpty(str)) {
      b();
    }
    for (;;)
    {
      JSONObject localJSONObject1;
      try
      {
        JSONObject localJSONObject3 = new JSONObject(str);
        JSONObject localJSONObject2 = localJSONObject3.optJSONObject("festival");
        boolean bool1;
        if (localJSONObject2 != null)
        {
          try
          {
            bool1 = "1".equals(localJSONObject2.optString("enable"));
            m = localJSONObject2.optInt("priority");
          }
          catch (Throwable localThrowable1)
          {
            break label321;
          }
        }
        else
        {
          bool1 = false;
          m = 1;
        }
        localJSONObject1 = null;
        Object localObject1 = this.a;
        if (localObject1 == null) {
          break label397;
        }
        n = (int)((((Card)localObject1).lBirthday & 0xFF00) >> 8);
        int i1 = (int)(((Card)localObject1).lBirthday & 0xFF);
        localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).setTimeInMillis(System.currentTimeMillis());
        int i2 = ((Calendar)localObject1).get(2);
        try
        {
          int i3 = ((Calendar)localObject1).get(5);
          localObject1 = localJSONObject1;
          if (n != i2 + 1) {
            break label401;
          }
          localObject1 = localJSONObject1;
          if (i1 != i3) {
            break label401;
          }
          localJSONObject1 = localJSONObject3.optJSONObject("birthday");
          localObject1 = localJSONObject1;
          if (localJSONObject1 == null) {
            break label401;
          }
          bool2 = "1".equals(localJSONObject1.optString("enable"));
          n = localJSONObject1.optInt("priority");
          localObject1 = localJSONObject1;
          i1 = 1;
          if ((bool1) && (bool2))
          {
            if ((bool2) && (n >= m))
            {
              a((JSONObject)localObject1);
              break label414;
            }
            a(localJSONObject2);
            break label409;
          }
          if ((bool2) && (!bool1))
          {
            a((JSONObject)localObject1);
            break label414;
          }
          if ((bool1) && (!bool2))
          {
            a(localJSONObject2);
            break label409;
          }
          b();
          m = i1;
        }
        catch (Throwable localThrowable2) {}
        QLog.e("StickyNotePublishEntranceView", 2, localThrowable3, new Object[0]);
      }
      catch (Throwable localThrowable3) {}
      label321:
      int m = 1;
      this.k = m;
      if (this.b)
      {
        ReportController.b(null, "dc00898", "", "", "0X800AB1D", "0X800AB1D", m, 0, "0", "0", "", "");
        return;
      }
      ReportController.b(null, "dc00898", "", "", "0X800AB1E", "0X800AB1E", m, 0, "0", "0", "", "");
      return;
      label397:
      Object localObject2 = localJSONObject1;
      label401:
      boolean bool2 = false;
      int n = 2;
      continue;
      label409:
      m = 4;
      continue;
      label414:
      m = 3;
    }
  }
  
  protected void a(Context paramContext)
  {
    inflate(paramContext, 2131627741, this);
    this.c = ((ViewGroup)findViewById(2131431349));
    this.d = ((URLImageView)findViewById(2131437071));
    this.e = ((URLImageView)findViewById(2131429236));
    this.f = ((TextView)findViewById(2131446628));
    paramContext = paramContext.getResources();
    this.g = new ColorDrawable(paramContext.getColor(2131167324));
    this.h = new ColorDrawable(paramContext.getColor(2131167325));
    this.i = paramContext.getString(2131888141);
    this.j = paramContext.getString(2131888140);
    a();
  }
  
  public void a(Card paramCard)
  {
    this.a = paramCard;
    a();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    if ((this.a != null) && (paramJSONObject != null))
    {
      String str;
      if (this.b) {
        str = "host";
      } else {
        str = "guest";
      }
      Object localObject = paramJSONObject.optJSONObject(str);
      if (localObject != null)
      {
        paramJSONObject = ((JSONObject)localObject).optString("leftIcon");
        str = ((JSONObject)localObject).optString("bgUrl");
        localObject = ((JSONObject)localObject).optString("summary");
        if (!TextUtils.isEmpty(paramJSONObject)) {
          this.d.setBackgroundURL(paramJSONObject);
        } else {
          this.d.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str)) {
          this.e.setBackgroundURL(str);
        } else {
          this.e.setBackgroundDrawable(this.g);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.f.setText(a((String)localObject));
          return;
        }
        this.f.setVisibility(8);
      }
    }
  }
  
  protected void b()
  {
    this.d.setImageResource(2130847521);
    String str;
    if (this.b) {
      str = this.i;
    } else {
      str = this.j;
    }
    this.f.setText(a(str));
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      this.d.setColorFilter(1996488704);
      this.e.setBackgroundDrawable(this.h);
      return;
    }
    this.e.setBackgroundDrawable(this.g);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction();
    if (m != 0)
    {
      if (m != 1)
      {
        if (m == 3) {
          this.c.setAlpha(1.0F);
        }
      }
      else
      {
        this.c.setAlpha(1.0F);
        if (this.b) {
          ReportController.b(null, "dc00898", "", "", "0X800AB1F", "0X800AB1F", this.k, 0, "0", "0", "", "");
        } else {
          ReportController.b(null, "dc00898", "", "", "0X800AB20", "0X800AB20", this.k, 0, "0", "0", "", "");
        }
      }
    }
    else {
      this.c.setAlpha(0.5F);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setIsHost(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishEntranceView
 * JD-Core Version:    0.7.0.1
 */