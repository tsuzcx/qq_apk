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
  private int jdField_a_of_type_Int = 1;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private String jdField_b_of_type_JavaLangString;
  
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
      Card localCard = this.jdField_a_of_type_ComTencentMobileqqDataCard;
      localObject = paramString;
      if (localCard != null)
      {
        localObject = getContext().getResources();
        if (localCard.shGender == 0) {
          localObject = ((Resources)localObject).getString(2131693128);
        } else if (localCard.shGender == 1) {
          localObject = ((Resources)localObject).getString(2131719044);
        } else {
          localObject = ((Resources)localObject).getString(2131719435);
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
            i = localJSONObject2.optInt("priority");
          }
          catch (Throwable localThrowable1)
          {
            break label321;
          }
        }
        else
        {
          bool1 = false;
          i = 1;
        }
        localJSONObject1 = null;
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataCard;
        if (localObject1 == null) {
          break label397;
        }
        j = (int)((((Card)localObject1).lBirthday & 0xFF00) >> 8);
        int k = (int)(((Card)localObject1).lBirthday & 0xFF);
        localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).setTimeInMillis(System.currentTimeMillis());
        int m = ((Calendar)localObject1).get(2);
        try
        {
          int n = ((Calendar)localObject1).get(5);
          localObject1 = localJSONObject1;
          if (j != m + 1) {
            break label401;
          }
          localObject1 = localJSONObject1;
          if (k != n) {
            break label401;
          }
          localJSONObject1 = localJSONObject3.optJSONObject("birthday");
          localObject1 = localJSONObject1;
          if (localJSONObject1 == null) {
            break label401;
          }
          bool2 = "1".equals(localJSONObject1.optString("enable"));
          j = localJSONObject1.optInt("priority");
          localObject1 = localJSONObject1;
          k = 1;
          if ((bool1) && (bool2))
          {
            if ((bool2) && (j >= i))
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
          i = k;
        }
        catch (Throwable localThrowable2) {}
        QLog.e("StickyNotePublishEntranceView", 2, localThrowable3, new Object[0]);
      }
      catch (Throwable localThrowable3) {}
      label321:
      int i = 1;
      this.jdField_a_of_type_Int = i;
      if (this.jdField_a_of_type_Boolean)
      {
        ReportController.b(null, "dc00898", "", "", "0X800AB1D", "0X800AB1D", i, 0, "0", "0", "", "");
        return;
      }
      ReportController.b(null, "dc00898", "", "", "0X800AB1E", "0X800AB1E", i, 0, "0", "0", "", "");
      return;
      label397:
      Object localObject2 = localJSONObject1;
      label401:
      boolean bool2 = false;
      int j = 2;
      continue;
      label409:
      i = 4;
      continue;
      label414:
      i = 3;
    }
  }
  
  protected void a(Context paramContext)
  {
    inflate(paramContext, 2131561385, this);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131365187));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131369929));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131363350));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378121));
    paramContext = paramContext.getResources();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(paramContext.getColor(2131166482));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(paramContext.getColor(2131166483));
    this.jdField_a_of_type_JavaLangString = paramContext.getString(2131691195);
    this.jdField_b_of_type_JavaLangString = paramContext.getString(2131691194);
    a();
  }
  
  public void a(Card paramCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
    a();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramJSONObject != null))
    {
      String str;
      if (this.jdField_a_of_type_Boolean) {
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
          this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundURL(paramJSONObject);
        } else {
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str)) {
          this.jdField_b_of_type_ComTencentImageURLImageView.setBackgroundURL(str);
        } else {
          this.jdField_b_of_type_ComTencentImageURLImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(a((String)localObject));
          return;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130846051);
    String str;
    if (this.jdField_a_of_type_Boolean) {
      str = this.jdField_a_of_type_JavaLangString;
    } else {
      str = this.jdField_b_of_type_JavaLangString;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(str));
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setColorFilter(1996488704);
      this.jdField_b_of_type_ComTencentImageURLImageView.setBackgroundDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    this.jdField_b_of_type_ComTencentImageURLImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 3) {
          this.jdField_a_of_type_AndroidViewViewGroup.setAlpha(1.0F);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setAlpha(1.0F);
        if (this.jdField_a_of_type_Boolean) {
          ReportController.b(null, "dc00898", "", "", "0X800AB1F", "0X800AB1F", this.jdField_a_of_type_Int, 0, "0", "0", "", "");
        } else {
          ReportController.b(null, "dc00898", "", "", "0X800AB20", "0X800AB20", this.jdField_a_of_type_Int, 0, "0", "0", "", "");
        }
      }
    }
    else {
      this.jdField_a_of_type_AndroidViewViewGroup.setAlpha(0.5F);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setIsHost(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishEntranceView
 * JD-Core Version:    0.7.0.1
 */