package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class RedTouchUI
  extends RedTouch
{
  public RedAppInfo a;
  private List<RedTypeInfo> b;
  private int x = -1;
  private int y = -1;
  
  public RedTouchUI(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedTouchUI(Context paramContext, View paramView)
  {
    super(paramContext, paramView);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedAppInfo = null;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(RedTypeInfo paramRedTypeInfo)
  {
    int m = 0;
    int k = 0;
    if (paramRedTypeInfo == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      try
      {
        Object localObject;
        if (TextUtils.isEmpty(paramRedTypeInfo.getRedDesc()))
        {
          localObject = new JSONObject();
          if (!((JSONObject)localObject).has("bg")) {
            break label400;
          }
        }
        label400:
        for (int i = a(((JSONObject)localObject).getString("bg"));; i = 0) {
          switch (paramRedTypeInfo.getRedType())
          {
          case 0: 
            paramRedTypeInfo = a(i);
            if (paramRedTypeInfo == null) {
              break;
            }
            i = this.jdField_a_of_type_Int;
            this.jdField_a_of_type_Int = (i + 1);
            paramRedTypeInfo.setId(i);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTypeInfo);
            return;
            localObject = new JSONObject(paramRedTypeInfo.getRedDesc());
            break;
          case 3: 
            if (!((JSONObject)localObject).has("av")) {}
          case 4: 
          case 5: 
          case 9: 
            for (int j = ((JSONObject)localObject).getInt("av");; j = 0)
            {
              if (((JSONObject)localObject).has("dot")) {
                k = ((JSONObject)localObject).getInt("dot");
              }
              paramRedTypeInfo = a(paramRedTypeInfo.getRedContent(), j, k, i);
              if (paramRedTypeInfo == null) {
                break;
              }
              i = this.jdField_b_of_type_Int;
              this.jdField_b_of_type_Int = (i + 1);
              paramRedTypeInfo.setId(i);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTypeInfo);
              return;
              j = -1;
              if (((JSONObject)localObject).has("cr")) {
                j = a(((JSONObject)localObject).getString("cr"));
              }
              k = m;
              if (((JSONObject)localObject).has("cn")) {
                k = a(((JSONObject)localObject).getString("cn"));
              }
              localObject = a(paramRedTypeInfo.getRedContent(), j, k, i);
              if (localObject == null) {
                break;
              }
              if (paramRedTypeInfo.getRedType() == 4)
              {
                i = this.c;
                this.c = (i + 1);
              }
              for (;;)
              {
                ((View)localObject).setId(i);
                this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
                return;
                i = this.d;
                this.d = (i + 1);
              }
              paramRedTypeInfo = a(paramRedTypeInfo.getRedContent());
              if (paramRedTypeInfo == null) {
                break;
              }
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTypeInfo);
              return;
            }
          }
        }
        return;
      }
      catch (Exception paramRedTypeInfo) {}
    }
  }
  
  private boolean a(RedTypeInfo paramRedTypeInfo1, RedTypeInfo paramRedTypeInfo2)
  {
    if (paramRedTypeInfo1.getRedType() != paramRedTypeInfo2.getRedType()) {}
    while ((!paramRedTypeInfo1.getRedContent().equals(paramRedTypeInfo2.getRedContent())) || (!paramRedTypeInfo1.getRedDesc().equals(paramRedTypeInfo2.getRedDesc())) || (paramRedTypeInfo1.getRedPriority() != paramRedTypeInfo2.getRedPriority())) {
      return false;
    }
    return true;
  }
  
  private boolean a(List<RedTypeInfo> paramList)
  {
    if (this.jdField_b_of_type_JavaUtilList.size() == 0) {}
    while (this.jdField_b_of_type_JavaUtilList.size() != paramList.size()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_b_of_type_JavaUtilList.size()) {
        break label84;
      }
      if (!a((RedTypeInfo)this.jdField_b_of_type_JavaUtilList.get(i), (RedTypeInfo)paramList.get(i))) {
        break;
      }
      i += 1;
    }
    label84:
    return true;
  }
  
  public View a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    ((URLImageView)localObject).setBackgroundColor(paramInt3);
    a(paramString, (URLImageView)localObject, paramInt1);
    if (paramInt2 == 1)
    {
      if (this.x == -1) {
        throw new RuntimeException("must set the redpoint imageresource");
      }
      paramString = new FrameLayout(getContext());
      ((URLImageView)localObject).setLayoutParams(new FrameLayout.LayoutParams(a(36), a(36)));
      ((URLImageView)localObject).setPadding(a(3), a(3), a(3), a(3));
      paramString.addView((View)localObject);
      localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject).setImageResource(this.x);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 53;
      ((ImageView)localObject).setLayoutParams(localLayoutParams);
      paramString.addView((View)localObject);
      paramString.setLayoutParams(a());
      return paramString;
    }
    paramString = a();
    paramString.width = a(36);
    paramString.height = a(36);
    ((URLImageView)localObject).setLayoutParams(paramString);
    ((URLImageView)localObject).setPadding(a(3), a(3), a(3), a(3));
    return localObject;
  }
  
  public ImageView a(int paramInt)
  {
    if (this.x == -1) {
      throw new RuntimeException("must set the redpoint imageresource");
    }
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localImageView.setImageResource(this.x);
    localImageView.setBackgroundColor(paramInt);
    localImageView.setLayoutParams(a());
    return localImageView;
  }
  
  public TextView a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.y == -1) {
      throw new RuntimeException("must set the redpoint imageresource");
    }
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    try
    {
      if (Integer.parseInt(paramString) > this.p) {
        localTextView.setText(this.p + "+");
      }
      for (;;)
      {
        localTextView.setTextColor(paramInt1);
        localTextView.setGravity(17);
        localTextView.setSingleLine(true);
        if (paramInt2 == 0) {
          break;
        }
        localTextView.setTextSize(11.0F);
        localTextView.setBackgroundResource(this.y);
        localTextView.setLayoutParams(a());
        if (this.jdField_b_of_type_Boolean)
        {
          localTextView.measure(0, 0);
          this.l = (localTextView.getMeasuredWidth() / 2);
          c();
        }
        return localTextView;
        localTextView.setText(paramString);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localTextView.setText(paramString);
        continue;
        localTextView.setTextSize(13.0F);
      }
    }
  }
  
  public void a(RedAppInfo paramRedAppInfo)
  {
    d();
    if (paramRedAppInfo == null) {}
    do
    {
      return;
      this.jdField_b_of_type_JavaUtilList.clear();
    } while ((paramRedAppInfo.b() == 0) || (paramRedAppInfo.a() == null) || (paramRedAppInfo.a().a() == null) || (a(paramRedAppInfo.a().a())));
    this.jdField_b_of_type_JavaUtilList.addAll(paramRedAppInfo.a().a());
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((RedTypeInfo)localIterator.next());
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedAppInfo = paramRedAppInfo;
  }
  
  public void setRedpointImgResID(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void setTextOrNumImgRedID(int paramInt)
  {
    this.y = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchUI
 * JD-Core Version:    0.7.0.1
 */