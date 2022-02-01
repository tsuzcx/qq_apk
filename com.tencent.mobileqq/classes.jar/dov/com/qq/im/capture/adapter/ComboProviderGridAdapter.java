package dov.com.qq.im.capture.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anvx;
import bogd;
import bohe;
import bohj;
import bohv;
import bohz;
import boov;
import bpjt;
import bptp;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import java.util.List;
import zfn;

public class ComboProviderGridAdapter
  extends BaseAdapter
  implements Handler.Callback
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  public GridView a;
  List<QIMFilterCategoryItem> jdField_a_of_type_JavaUtilList;
  float b;
  float c;
  
  public ComboProviderGridAdapter(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int i = ViewUtils.dpToPx(5.0F);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(i, i, i, i);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    ((URLImageView)localObject2).setId(2131368381);
    ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131368790);
    ((ImageView)localObject2).setVisibility(8);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject2).setImageResource(2130844419);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    ((LinearLayout)localObject2).setId(2131371717);
    ((LinearLayout)localObject2).setOrientation(0);
    Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(13, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject3).setImageResource(2130844420);
    Object localObject4 = new LinearLayout.LayoutParams(ViewUtils.dpToPx(11.0F), ViewUtils.dpToPx(4.5F));
    ((LinearLayout.LayoutParams)localObject4).gravity = 16;
    ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject3).setId(2131371741);
    ((TextView)localObject3).setTextSize(2, 12.0F);
    ((TextView)localObject3).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167363));
    ((TextView)localObject3).setMaxLines(1);
    ((TextView)localObject3).setLines(1);
    ((TextView)localObject3).setShadowLayer(3.0F, 0.0F, 0.0F, Color.parseColor("#7F000000"));
    localObject4 = new LinearLayout.LayoutParams(-2, -2);
    i = ViewUtils.dpToPx(5.0F);
    ((LinearLayout.LayoutParams)localObject4).leftMargin = i;
    ((LinearLayout.LayoutParams)localObject4).rightMargin = i;
    ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject3).setImageResource(2130844420);
    localObject4 = new LinearLayout.LayoutParams(ViewUtils.dpToPx(11.0F), ViewUtils.dpToPx(4.5F));
    ((LinearLayout.LayoutParams)localObject4).gravity = 16;
    ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject2).setId(2131369056);
    ((RelativeLayout)localObject2).setBackgroundResource(2130844498);
    ((RelativeLayout)localObject2).setVisibility(8);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = ViewUtils.dpToPx(16.0F);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject3).setCompoundDrawables(null, null, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844499), null);
    ((TextView)localObject3).setCompoundDrawablePadding(ViewUtils.dpToPx(4.0F));
    ((TextView)localObject3).setText(anvx.a(2131701663));
    ((TextView)localObject3).setTextSize(2, 12.0F);
    ((TextView)localObject3).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167363));
    localObject4 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(13, -1);
    ((RelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131366800);
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167363));
    ((TextView)localObject2).setMaxLines(1);
    ((TextView)localObject2).setLines(1);
    ((TextView)localObject2).setShadowLayer(3.0F, 0.0F, 0.0F, Color.parseColor("#7F000000"));
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).bottomMargin = ViewUtils.dpToPx(5.0F);
    ((RelativeLayout.LayoutParams)localObject3).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(12, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new QIMCommonLoadingView(this.jdField_a_of_type_AndroidContentContext);
    ((QIMCommonLoadingView)localObject2).setId(2131366805);
    ((QIMCommonLoadingView)localObject2).setVisibility(8);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131365253);
    ((ImageView)localObject1).setImageResource(2130845935);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131381546);
    ((ImageView)localObject1).setVisibility(8);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    return localRelativeLayout;
  }
  
  public static void a(ImageView paramImageView, bohe parambohe, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    bpjt.a();
    boolean bool1 = bpjt.a(3, paramQIMFilterCategoryItem.jdField_a_of_type_Int, paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
    int i = parambohe.jdField_a_of_type_Int;
    boolean bool2 = ((bohj)bogd.a(5)).a().a(paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
    if ((bool2) || (paramQIMFilterCategoryItem.jdField_a_of_type_Boolean) || (bool1))
    {
      paramImageView.setVisibility(0);
      if (bool2)
      {
        paramImageView.setImageResource(2130844534);
        return;
      }
      if (bool1)
      {
        paramImageView.setImageResource(2130845936);
        return;
      }
      switch (i)
      {
      default: 
        return;
      case 1: 
      case 3: 
        paramImageView.setVisibility(8);
        return;
      }
      paramImageView.setImageResource(2130845935);
      return;
    }
    paramImageView.setVisibility(8);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(9, 600L);
  }
  
  public void a(int paramInt)
  {
    QIMFilterCategoryItem localQIMFilterCategoryItem = ((bohj)bogd.a(5)).a().a;
    if ((localQIMFilterCategoryItem != null) && (localQIMFilterCategoryItem.jdField_a_of_type_Int == paramInt)) {
      a();
    }
  }
  
  public void a(ImageView paramImageView, AnimationDrawable paramAnimationDrawable, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ComboProviderGridAdapter", 2, "showUnlockAnimation ");
    }
    ImageView localImageView = new ImageView(paramImageView.getContext());
    PopupWindow localPopupWindow = new PopupWindow(localImageView, -2, -2, true);
    localPopupWindow.setTouchable(true);
    localPopupWindow.setClippingEnabled(false);
    localPopupWindow.setOutsideTouchable(true);
    localPopupWindow.setBackgroundDrawable(new ColorDrawable(16777215));
    int[] arrayOfInt = new int[2];
    paramImageView.getLocationOnScreen(arrayOfInt);
    if (QLog.isColorLevel()) {
      QLog.i("ComboProviderGridAdapter", 2, "showUnlockAnimation " + arrayOfInt[0] + "," + arrayOfInt[1]);
    }
    int i = bptp.a(60.0F) - paramImageView.getWidth();
    localPopupWindow.showAtLocation(paramImageView, 8388659, arrayOfInt[0] - i / 2, arrayOfInt[1] - i / 2);
    paramAnimationDrawable.setOneShot(true);
    paramAnimationDrawable = new ComboProviderGridAdapter.LockAnimationDrawable(paramAnimationDrawable, localImageView, localPopupWindow, paramImageView, paramQIMFilterCategoryItem);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ComboProviderGridAdapter.1(this, paramImageView), 200L);
    localImageView.setImageDrawable(paramAnimationDrawable);
    paramAnimationDrawable.start();
  }
  
  public void a(List<QIMFilterCategoryItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
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
    if ((this.jdField_a_of_type_Float <= 0.0F) && (paramViewGroup != null))
    {
      this.jdField_a_of_type_Float = paramViewGroup.getMeasuredWidth();
      this.b = ((this.jdField_a_of_type_Float - FilterProviderPagerAdapter.b * 3 - paramViewGroup.getPaddingLeft() - paramViewGroup.getPaddingRight()) / 4.0F + 0.5F);
      this.c = (12.0F * this.b / 160.0F);
    }
    if (paramView == null) {
      paramView = a();
    }
    for (;;)
    {
      TextView localTextView1 = (TextView)paramView.findViewById(2131366800);
      ImageView localImageView3 = (ImageView)paramView.findViewById(2131368790);
      ImageView localImageView1 = (ImageView)paramView.findViewById(2131368381);
      ImageView localImageView2 = (ImageView)paramView.findViewById(2131365253);
      TextView localTextView2 = (TextView)paramView.findViewById(2131371741);
      View localView = paramView.findViewById(2131371717);
      QIMCommonLoadingView localQIMCommonLoadingView = (QIMCommonLoadingView)paramView.findViewById(2131366805);
      QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      bohj localbohj = (bohj)bogd.a(5);
      Object localObject1 = bpjt.a().a[this.jdField_a_of_type_Int];
      if (localObject1 != null) {}
      for (localObject1 = (QIMFilterCategoryItem)((bohz)localObject1).a;; localObject1 = null)
      {
        boolean bool = false;
        if (localObject1 != null) {
          bool = TextUtils.equals(((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaLangString, localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
        }
        if (!bool) {
          if (((localObject1 == null) || (((QIMFilterCategoryItem)localObject1).c())) && (localQIMFilterCategoryItem.c())) {
            bool = true;
          }
        }
        for (;;)
        {
          paramView.setTag(localQIMFilterCategoryItem);
          Object localObject2 = (AbsListView.LayoutParams)paramView.getLayoutParams();
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new AbsListView.LayoutParams(-1, -1);
            paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          ((AbsListView.LayoutParams)localObject1).height = ((int)this.b);
          if (localQIMFilterCategoryItem.c())
          {
            localImageView3.setVisibility(8);
            if (bool)
            {
              localImageView1.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844422));
              label347:
              localImageView2.setVisibility(8);
              localTextView1.setVisibility(0);
              localTextView1.setText(anvx.a(2131701664));
              localView.setVisibility(8);
            }
          }
          for (;;)
          {
            if ((localbohj.a().a != null) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(9))) {}
            EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
            return paramView;
            bool = false;
            break;
            localImageView1.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844423));
            break label347;
            localTextView1.setVisibility(8);
            localObject1 = localbohj.a(localQIMFilterCategoryItem);
            if (!TextUtils.isEmpty(localQIMFilterCategoryItem.b))
            {
              localView.setVisibility(0);
              localTextView2.setText(localQIMFilterCategoryItem.b);
              label487:
              if (!bool) {
                break label699;
              }
              localImageView3.setImageResource(2130844421);
              localImageView3.setVisibility(0);
              localTextView1.setShadowLayer(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166975));
              label527:
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844418);
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844418);
              ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
              localQIMCommonLoadingView.setMax(10000);
              localObject2 = URLDrawable.getDrawable(localQIMFilterCategoryItem.d, (URLDrawable.URLDrawableOptions)localObject2);
              if (((URLDrawable)localObject2).getStatus() == 2) {
                ((URLDrawable)localObject2).restartDownload();
              }
              localImageView1.setImageDrawable((Drawable)localObject2);
              localTextView1.setText(localQIMFilterCategoryItem.b);
              if (!localQIMFilterCategoryItem.f()) {
                break label742;
              }
              localImageView2.setVisibility(8);
              localObject1 = (ImageView)paramView.findViewById(2131381546);
              if (!localQIMFilterCategoryItem.a()) {
                break label731;
              }
              ((ImageView)localObject1).setImageResource(2130845929);
            }
            for (;;)
            {
              ((ImageView)localObject1).setVisibility(0);
              zfn.a(localQIMFilterCategoryItem);
              break;
              localTextView2.setText("");
              localView.setVisibility(8);
              break label487;
              label699:
              localImageView3.setVisibility(8);
              localTextView1.setShadowLayer(3.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166975));
              break label527;
              label731:
              ((ImageView)localObject1).setImageResource(2130845942);
            }
            label742:
            ((ImageView)paramView.findViewById(2131381546)).setVisibility(8);
            localQIMCommonLoadingView.setVisibility(0);
            localQIMCommonLoadingView.setBgCorner(this.c);
            localQIMCommonLoadingView.a(boov.a(localObject1));
            a(localImageView2, (bohe)localObject1, localQIMFilterCategoryItem);
          }
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 9)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetGridView == null) || (!this.jdField_a_of_type_ComTencentWidgetGridView.isShown()))
      {
        QLog.i("ComboLockManager", 1, "checkAnim err, ignore");
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "checkAnim");
      }
      int j = this.jdField_a_of_type_ComTencentWidgetGridView.getChildCount();
      paramMessage = (bohj)bogd.a(5);
      QIMFilterCategoryItem localQIMFilterCategoryItem = paramMessage.a().a;
      int i;
      if (localQIMFilterCategoryItem != null) {
        i = 0;
      }
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        if (i < j)
        {
          localObject1 = this.jdField_a_of_type_ComTencentWidgetGridView.getChildAt(i);
          localObject2 = ((View)localObject1).getTag();
          if ((!QIMFilterCategoryItem.class.isInstance(localObject2)) || (!((QIMFilterCategoryItem)localObject2).jdField_a_of_type_JavaLangString.equals(localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString))) {}
        }
        else
        {
          try
          {
            localObject1 = (ImageView)((View)localObject1).findViewById(2131365253);
            localObject2 = (AnimationDrawable)((ImageView)localObject1).getContext().getResources().getDrawable(2130844649);
            paramMessage.a().a = null;
            a((ImageView)localObject1, (AnimationDrawable)localObject2, localQIMFilterCategoryItem);
            return true;
          }
          catch (Exception paramMessage)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i("ComboProviderGridAdapter", 2, "showUnlockAnimation err", paramMessage);
              }
            }
          }
        }
        i += 1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.ComboProviderGridAdapter
 * JD-Core Version:    0.7.0.1
 */