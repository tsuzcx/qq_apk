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
import bdla;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.theme.ThemeUtil;
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
    Card localCard;
    if (!TextUtils.isEmpty(paramString))
    {
      localCard = this.jdField_a_of_type_ComTencentMobileqqDataCard;
      localObject = paramString;
      if (localCard != null)
      {
        localObject = getContext().getResources();
        if (localCard.shGender != 0) {
          break label52;
        }
        localObject = ((Resources)localObject).getString(2131693022);
      }
    }
    for (;;)
    {
      localObject = paramString.replace("{TA}", (CharSequence)localObject);
      return localObject;
      label52:
      if (localCard.shGender == 1) {
        localObject = ((Resources)localObject).getString(2131718801);
      } else {
        localObject = ((Resources)localObject).getString(2131719157);
      }
    }
  }
  
  public void a()
  {
    Object localObject = (String)VSConfigManager.getInstance().getValue("sticky_note_publish_entrance_config", "");
    int i;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      b();
      i = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = i;
      if (this.jdField_a_of_type_Boolean)
      {
        bdla.b(null, "dc00898", "", "", "0X800AB1D", "0X800AB1D", i, 0, "0", "0", "", "");
        return;
      }
      for (;;)
      {
        try
        {
          JSONObject localJSONObject3 = new JSONObject((String)localObject);
          JSONObject localJSONObject2 = localJSONObject3.optJSONObject("festival");
          if (localJSONObject2 == null) {
            break label421;
          }
          bool1 = "1".equals(localJSONObject2.optString("enable"));
          i = localJSONObject2.optInt("priority");
          JSONObject localJSONObject1 = null;
          boolean bool3 = false;
          int k = 2;
          Card localCard = this.jdField_a_of_type_ComTencentMobileqqDataCard;
          int j = k;
          boolean bool2 = bool3;
          localObject = localJSONObject1;
          if (localCard != null)
          {
            int m = (int)((localCard.lBirthday & 0xFF00) >> 8);
            int n = (int)(localCard.lBirthday & 0xFF);
            localObject = Calendar.getInstance();
            ((Calendar)localObject).setTimeInMillis(System.currentTimeMillis());
            int i1 = ((Calendar)localObject).get(2);
            int i2 = ((Calendar)localObject).get(5);
            j = k;
            bool2 = bool3;
            localObject = localJSONObject1;
            if (m == i1 + 1)
            {
              j = k;
              bool2 = bool3;
              localObject = localJSONObject1;
              if (n == i2)
              {
                localJSONObject1 = localJSONObject3.optJSONObject("birthday");
                j = k;
                bool2 = bool3;
                localObject = localJSONObject1;
                if (localJSONObject1 != null)
                {
                  bool2 = "1".equals(localJSONObject1.optString("enable"));
                  j = localJSONObject1.optInt("priority");
                  localObject = localJSONObject1;
                }
              }
            }
          }
          if ((bool1) && (bool2))
          {
            if ((bool2) && (j >= i))
            {
              a((JSONObject)localObject);
              i = 3;
            }
            else
            {
              a(localJSONObject2);
              i = 4;
            }
          }
          else if ((bool2) && (!bool1))
          {
            a((JSONObject)localObject);
            i = 3;
          }
          else if ((bool1) && (!bool2))
          {
            a(localJSONObject2);
            i = 4;
          }
          else
          {
            b();
            i = 1;
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("StickyNotePublishEntranceView", 2, localThrowable, new Object[0]);
          i = 1;
        }
        break;
        bdla.b(null, "dc00898", "", "", "0X800AB1E", "0X800AB1E", i, 0, "0", "0", "", "");
        return;
        label421:
        i = 1;
        boolean bool1 = false;
      }
    }
  }
  
  protected void a(Context paramContext)
  {
    inflate(paramContext, 2131561437, this);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131365174));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131369991));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131363340));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378300));
    paramContext = paramContext.getResources();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(paramContext.getColor(2131166468));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(paramContext.getColor(2131166469));
    this.jdField_a_of_type_JavaLangString = paramContext.getString(2131691167);
    this.jdField_b_of_type_JavaLangString = paramContext.getString(2131691166);
    a();
  }
  
  public void a(Card paramCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
    a();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    String str;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramJSONObject != null))
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label102;
      }
      str = "host";
      localObject = paramJSONObject.optJSONObject(str);
      if (localObject != null)
      {
        paramJSONObject = ((JSONObject)localObject).optString("leftIcon");
        str = ((JSONObject)localObject).optString("bgUrl");
        localObject = ((JSONObject)localObject).optString("summary");
        if (TextUtils.isEmpty(paramJSONObject)) {
          break label108;
        }
        this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundURL(paramJSONObject);
        label67:
        if (TextUtils.isEmpty(str)) {
          break label120;
        }
        this.jdField_b_of_type_ComTencentImageURLImageView.setBackgroundURL(str);
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label134;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a((String)localObject));
      return;
      label102:
      str = "guest";
      break;
      label108:
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label67;
      label120:
      this.jdField_b_of_type_ComTencentImageURLImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    label134:
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130845854);
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = this.jdField_a_of_type_JavaLangString;; str = this.jdField_b_of_type_JavaLangString)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(str));
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break;
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setColorFilter(1996488704);
      this.jdField_b_of_type_ComTencentImageURLImageView.setBackgroundDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    this.jdField_b_of_type_ComTencentImageURLImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_AndroidViewViewGroup.setAlpha(0.5F);
      continue;
      this.jdField_a_of_type_AndroidViewViewGroup.setAlpha(1.0F);
      if (this.jdField_a_of_type_Boolean)
      {
        bdla.b(null, "dc00898", "", "", "0X800AB1F", "0X800AB1F", this.jdField_a_of_type_Int, 0, "0", "0", "", "");
      }
      else
      {
        bdla.b(null, "dc00898", "", "", "0X800AB20", "0X800AB20", this.jdField_a_of_type_Int, 0, "0", "0", "", "");
        continue;
        this.jdField_a_of_type_AndroidViewViewGroup.setAlpha(1.0F);
      }
    }
  }
  
  public void setIsHost(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishEntranceView
 * JD-Core Version:    0.7.0.1
 */