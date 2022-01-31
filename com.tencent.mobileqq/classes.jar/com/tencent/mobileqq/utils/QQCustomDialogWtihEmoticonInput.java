package com.tencent.mobileqq.utils;

import akeo;
import akep;
import akeq;
import aker;
import akes;
import aket;
import akev;
import akew;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.devicelib.DeviceLib;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import com.tencent.util.InputMethodUtil;
import java.lang.ref.SoftReference;

public class QQCustomDialogWtihEmoticonInput
  extends QQCustomDialog
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 1;
  Resources jdField_a_of_type_AndroidContentResResources = null;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  public WindowManager.LayoutParams a;
  public WindowManager a;
  public EditText a;
  public ImageView a;
  public RelativeLayout a;
  public SystemEmoticonPanel a;
  public SoftReference a;
  boolean jdField_a_of_type_Boolean = false;
  public boolean b;
  
  public QQCustomDialogWtihEmoticonInput(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = null;
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    if (localLayoutParams != null) {
      localLayoutParams.gravity = 17;
    }
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramContext);
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    getWindow().setSoftInputMode(19);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams(-1, (int)(150.0F * paramContext.getResources().getDisplayMetrics().density), 2, 32, -1);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 81;
  }
  
  public int a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return "";
    }
    Object localObject;
    if ((this.jdField_a_of_type_AndroidWidgetEditText.getText() instanceof QzoneTextBuilder))
    {
      localObject = (QzoneTextBuilder)this.jdField_a_of_type_AndroidWidgetEditText.getText();
      if (localObject != null) {
        return ((QzoneTextBuilder)localObject).a();
      }
    }
    else if ((this.jdField_a_of_type_AndroidWidgetEditText.getText() instanceof QQTextBuilder))
    {
      localObject = (QQTextBuilder)this.jdField_a_of_type_AndroidWidgetEditText.getText();
      if (localObject != null) {
        return ((QQTextBuilder)localObject).a();
      }
    }
    return this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QzoneTextBuilder.b);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  void a(Context paramContext)
  {
    aker localaker = new aker(this);
    if (this.jdField_a_of_type_Int == 7)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = new SystemAndEmojiEmoticonPanel(paramContext, localaker);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = new SystemEmoticonPanel(paramContext, localaker);
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new akeq(this, paramInt));
    }
  }
  
  public EditText getEditText()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText;
  }
  
  public String getInputValue()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364075)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel != null)
      {
        if (this.b)
        {
          this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel);
          this.b = false;
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845858);
          this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130845858));
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new akes(this), 200L);
        }
      }
      else {
        return;
      }
      paramView = this.jdField_a_of_type_AndroidWidgetImageView.getTag();
      if ((paramView != null) && ((paramView instanceof Integer)) && (((Integer)paramView).intValue() == 2130844546))
      {
        InputMethodUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845858);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130845858));
        this.b = false;
        return;
      }
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844546);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130844546));
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aket(this), 200L);
      return;
    }
    if (this.b)
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel);
      this.b = false;
      paramView = getWindow().getAttributes();
      paramView.y = 0;
      getWindow().setAttributes(paramView);
    }
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 1) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.b)
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel);
      this.b = false;
      WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
      localLayoutParams.y = 0;
      getWindow().setAttributes(localLayoutParams);
    }
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  @TargetApi(11)
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364032));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131363497));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364075));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    findViewById(2131364073).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QQTextBuilder.a);
    this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new akeo(this));
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    if (localContext == null) {
      return;
    }
    DeviceLib.a(localContext, this.jdField_a_of_type_AndroidWidgetEditText);
    a(localContext);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setBackgroundResource(2130837571);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setDispatchKeyEventListener(new akep(this));
  }
  
  public QQCustomDialog setNegativeButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramInt);
    this.lBtn.setContentDescription(getContext().getString(paramInt) + getContext().getString(2131427457));
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new akev(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public QQCustomDialog setPositiveButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramInt);
    this.rBtn.setContentDescription(getContext().getString(paramInt));
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new akew(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public QQCustomDialog setPreviewImage(Drawable paramDrawable, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    int i = paramDrawable.getIntrinsicWidth();
    Object localObject;
    if (paramDrawable.getIntrinsicHeight() > i)
    {
      localObject = ((URLDrawable)paramDrawable).getCurrDrawable();
      if ((localObject instanceof RegionDrawable))
      {
        localObject = ((RegionDrawable)localObject).getBitmap();
        if (localObject != null)
        {
          Matrix localMatrix = new Matrix();
          localMatrix.postScale(0.5F, 0.5F);
          localObject = Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), localMatrix, true);
          if (localObject != null)
          {
            localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentResResources, (Bitmap)localObject);
            ((BitmapDrawable)localObject).setBounds(0, 0, ((BitmapDrawable)localObject).getIntrinsicWidth(), ((BitmapDrawable)localObject).getIntrinsicHeight());
          }
        }
      }
    }
    for (;;)
    {
      if (localObject == null) {
        return super.setPreviewImage(paramDrawable, paramBoolean1, paramInt, paramBoolean2);
      }
      return super.setPreviewImage((Drawable)localObject, paramBoolean1, paramInt, paramBoolean2);
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput
 * JD-Core Version:    0.7.0.1
 */