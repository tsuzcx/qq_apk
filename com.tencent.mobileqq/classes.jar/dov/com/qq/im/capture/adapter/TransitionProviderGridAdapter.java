package dov.com.qq.im.capture.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.data.TransitionCategoryItem;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransitionProviderGridAdapter
  extends BaseAdapter
{
  public static final int a;
  public static final int b;
  public static final int c = ViewUtils.b(10.0F);
  float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  List jdField_a_of_type_JavaUtilList = new ArrayList(0);
  public boolean a;
  float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  int d;
  
  static
  {
    jdField_a_of_type_Int = ViewUtils.b(40.0F);
    jdField_b_of_type_Int = ViewUtils.b(5.0F);
  }
  
  public TransitionProviderGridAdapter(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.d = paramInt;
  }
  
  private View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    if (!this.jdField_a_of_type_Boolean) {
      localFrameLayout.setPadding(c, c, c, c);
    }
    for (;;)
    {
      ((RelativeLayout.LayoutParams)localObject1).setMargins(jdField_b_of_type_Int, jdField_b_of_type_Int, jdField_b_of_type_Int, jdField_b_of_type_Int);
      localRelativeLayout.addView(localFrameLayout, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
      ((URLImageView)localObject1).setId(2131362724);
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
      Object localObject2 = new FrameLayout.LayoutParams(jdField_a_of_type_Int, jdField_a_of_type_Int);
      ((FrameLayout.LayoutParams)localObject2).gravity = 49;
      localFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject2).setId(2131369942);
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setTextSize(2, 12.0F);
      ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492969));
      ((TextView)localObject2).setMaxLines(1);
      ((TextView)localObject2).setLines(1);
      ((TextView)localObject2).setShadowLayer(3.0F, 0.0F, 0.0F, Color.parseColor("#7F000000"));
      Object localObject3 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject3).gravity = 81;
      localFrameLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new TransitionProviderGridAdapter.ConvertViewTag();
      ((TransitionProviderGridAdapter.ConvertViewTag)localObject3).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject1);
      ((TransitionProviderGridAdapter.ConvertViewTag)localObject3).jdField_a_of_type_AndroidViewView = localFrameLayout;
      ((TransitionProviderGridAdapter.ConvertViewTag)localObject3).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      ((TransitionProviderGridAdapter.ConvertViewTag)localObject3).jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      localRelativeLayout.setTag(localObject3);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject3);
      return localRelativeLayout;
      localFrameLayout.setPadding(jdField_b_of_type_Int, 0, jdField_b_of_type_Int, jdField_b_of_type_Int);
    }
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      try
      {
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        if (paramString.getStatus() == 2) {
          paramString.restartDownload();
        }
        paramImageView.setImageDrawable(paramString);
        return;
      }
      catch (Error paramImageView) {}
    } while (!QLog.isColorLevel());
    QLog.d("TransitionProviderGridAdapter", 2, "setStaticURLDrawable " + paramImageView.toString());
  }
  
  private void b(ImageView paramImageView, String paramString)
  {
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString))) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getFilesDir() + "/shortvideo_transition_preview/";
      Object localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdir();
      }
      localObject2 = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.lastIndexOf("."));
      localObject1 = VasApngUtil.a(BaseApplicationImpl.sApplication.getRuntime(), (String)localObject1 + (String)localObject2, paramString, null, new int[] { 16 }, "-Transition-", null);
      if (localObject1 == null) {
        break;
      }
      paramImageView.setImageDrawable((Drawable)localObject1);
    } while (((URLDrawable)localObject1).getStatus() != 2);
    if (QLog.isColorLevel()) {
      QLog.d("TransitionProviderGridAdapter", 2, "restartDownload apng:" + paramString);
    }
    ((URLDrawable)localObject1).restartDownload();
    return;
    throw new Exception("urlDrawableApng null");
  }
  
  public void a()
  {
    TransitionCategoryItem localTransitionCategoryItem = VideoFilterTools.a().a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    TransitionProviderGridAdapter.ConvertViewTag localConvertViewTag;
    boolean bool2;
    label66:
    boolean bool1;
    if (localIterator.hasNext())
    {
      localConvertViewTag = (TransitionProviderGridAdapter.ConvertViewTag)localIterator.next();
      if (localConvertViewTag.jdField_a_of_type_DovComQqImCaptureDataTransitionCategoryItem == null) {
        break label116;
      }
      if (localTransitionCategoryItem == null) {
        break label111;
      }
      bool2 = TextUtils.equals(localTransitionCategoryItem.a, localConvertViewTag.jdField_a_of_type_DovComQqImCaptureDataTransitionCategoryItem.a);
      bool1 = bool2;
      if (!bool2)
      {
        if (((localTransitionCategoryItem != null) && (!localTransitionCategoryItem.c())) || (!localConvertViewTag.jdField_a_of_type_DovComQqImCaptureDataTransitionCategoryItem.c())) {
          break label105;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      localConvertViewTag.a(bool1);
      break;
      label105:
      bool1 = false;
      continue;
      return;
      label111:
      bool2 = false;
      break label66;
      label116:
      bool1 = false;
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TransitionProviderGridAdapter", 2, "onDestroy");
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool3 = false;
    if ((this.jdField_a_of_type_Float <= 0.0F) && (paramViewGroup != null))
    {
      this.jdField_a_of_type_Float = paramViewGroup.getMeasuredWidth();
      if (!this.jdField_a_of_type_Boolean) {
        break label105;
      }
    }
    label105:
    for (this.jdField_b_of_type_Float = ((this.jdField_a_of_type_Float - paramViewGroup.getPaddingLeft() - paramViewGroup.getPaddingRight()) / 3.2F + 0.5F);; this.jdField_b_of_type_Float = ((this.jdField_a_of_type_Float - paramViewGroup.getPaddingLeft() - paramViewGroup.getPaddingRight()) / 4.0F + 0.5F))
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = a();
      }
      if ((paramViewGroup.getTag() != null) && ((paramViewGroup.getTag() instanceof TransitionProviderGridAdapter.ConvertViewTag))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TransitionProviderGridAdapter", 2, "ConvertViewTag null");
      }
      return paramViewGroup;
    }
    TransitionProviderGridAdapter.ConvertViewTag localConvertViewTag = (TransitionProviderGridAdapter.ConvertViewTag)paramViewGroup.getTag();
    TextView localTextView = localConvertViewTag.jdField_a_of_type_AndroidWidgetTextView;
    URLImageView localURLImageView = localConvertViewTag.jdField_a_of_type_ComTencentImageURLImageView;
    TransitionCategoryItem localTransitionCategoryItem = (TransitionCategoryItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localConvertViewTag.jdField_a_of_type_DovComQqImCaptureDataTransitionCategoryItem = localTransitionCategoryItem;
    paramView = VideoFilterTools.a().a();
    if (paramView != null) {}
    for (boolean bool1 = TextUtils.equals(paramView.a, localTransitionCategoryItem.a);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        if (paramView != null)
        {
          bool1 = bool3;
          if (!paramView.c()) {}
        }
        else
        {
          bool1 = bool3;
          if (localTransitionCategoryItem.c()) {
            bool1 = true;
          }
        }
        bool2 = bool1;
      }
      AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)paramViewGroup.getLayoutParams();
      paramView = localLayoutParams;
      if (localLayoutParams == null)
      {
        paramView = new AbsListView.LayoutParams(-1, -1);
        paramViewGroup.setLayoutParams(paramView);
      }
      paramView.height = ((int)this.jdField_b_of_type_Float);
      localConvertViewTag.a(bool2);
      try
      {
        b(localURLImageView, localTransitionCategoryItem.h);
        localTextView.setText(localTransitionCategoryItem.b);
        paramViewGroup.setFocusable(true);
        paramViewGroup.setFocusableInTouchMode(true);
        paramViewGroup.setContentDescription(localTransitionCategoryItem.b + " 按钮");
        return paramViewGroup;
      }
      catch (Error paramView)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TransitionProviderGridAdapter", 2, "setApngURLDrawable " + paramView.toString());
          }
          a(localURLImageView, localTransitionCategoryItem.c);
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TransitionProviderGridAdapter", 2, "setApngURLDrawable " + paramView.toString());
          }
          a(localURLImageView, localTransitionCategoryItem.c);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.TransitionProviderGridAdapter
 * JD-Core Version:    0.7.0.1
 */