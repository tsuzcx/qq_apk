package com.tencent.mobileqq.emoticonview;

import abju;
import aciy;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankh;
import anlh;
import anlj;
import awqx;
import behk;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.emotionintegrate.EmotionGallery;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class EmotionPreviewFragment
  extends PublicBaseFragment
  implements View.OnClickListener, anlj, behk
{
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ankh jdField_a_of_type_Ankh;
  private anlh jdField_a_of_type_Anlh;
  private EmotionGallery jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery;
  private NumberCheckBox jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private ArrayList<EmotionPreviewInfo> jdField_a_of_type_JavaUtilArrayList;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  private int a()
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      i = j;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          if (!((EmotionPreviewInfo)localIterator.next()).jdField_a_of_type_Boolean) {
            break label66;
          }
          i += 1;
        }
      }
    }
    label66:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private int a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      int j = this.jdField_a_of_type_JavaUtilArrayList.size();
      int i = 0;
      while (i < j)
      {
        if (((EmotionPreviewInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList = getActivity().getIntent().getParcelableArrayListExtra("preview_data");
    this.jdField_a_of_type_Ankh.a(this.jdField_a_of_type_JavaUtilArrayList);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((EmotionPreviewInfo)localIterator.next()).jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Anlh = new anlh(getActivity(), this);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Anlh);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this.jdField_a_of_type_Anlh);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(aciy.a(14.0F, getResources()));
      this.jdField_a_of_type_Anlh.a(localArrayList);
      this.jdField_a_of_type_Anlh.a(((EmotionPreviewInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString);
    }
    c();
    b(1);
    a(0, 0);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox != null)
    {
      EmotionPreviewInfo localEmotionPreviewInfo = (EmotionPreviewInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(localEmotionPreviewInfo.jdField_a_of_type_Boolean);
      if ((localEmotionPreviewInfo.jdField_a_of_type_Boolean) && (paramInt2 >= 0)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(paramInt2 + 1);
      }
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramIntent != null))
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        EmotionPreviewInfo localEmotionPreviewInfo = new EmotionPreviewInfo();
        localEmotionPreviewInfo.jdField_a_of_type_JavaLangString = str;
        localEmotionPreviewInfo.jdField_a_of_type_Boolean = true;
        localArrayList.add(localEmotionPreviewInfo);
      }
      paramIntent.putParcelableArrayListExtra("preview_data", localArrayList);
      abju.a(paramActivity, paramIntent, PublicFragmentActivity.class, EmotionPreviewFragment.class, 100015);
    }
  }
  
  private void b()
  {
    Intent localIntent = getActivity().getIntent();
    localIntent.setClass(getActivity(), NewPhotoListActivity.class);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Anlh.a());
    localIntent.addFlags(603979776);
    startActivity(localIntent);
    getActivity().finish();
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt + "/" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
  }
  
  private void c()
  {
    int i;
    StringBuffer localStringBuffer;
    if (this.jdField_a_of_type_AndroidWidgetButton != null)
    {
      i = a();
      localStringBuffer = new StringBuffer(getResources().getString(2131629467));
      if (i < 1) {
        this.jdField_a_of_type_AndroidWidgetButton.setText(localStringBuffer.toString());
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText("(" + i + ")");
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2131493471, paramViewGroup, false);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Anlh != null)
    {
      ArrayList localArrayList = this.jdField_a_of_type_Anlh.a();
      if ((localArrayList != null) && (paramInt < localArrayList.size()))
      {
        int i = a((String)localArrayList.get(paramInt));
        if (i >= 0)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery != null) {
            this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setSelection(i);
          }
          b(i + 1);
          a(i, paramInt);
        }
      }
    }
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131310076));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131300880);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131311553));
    ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery = ((EmotionGallery)paramView.findViewById(2131301286));
    this.jdField_a_of_type_Ankh = new ankh(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setAdapter(this.jdField_a_of_type_Ankh);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setSpacing(getActivity().getResources().getDimensionPixelSize(2131165934));
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnItemSelectedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnNoBlankListener(this.jdField_a_of_type_Ankh);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.b(false);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a(false);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)paramView.findViewById(2131300881));
    a();
  }
  
  public void a(AdapterView<?> paramAdapterView) {}
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i;
    if ((this.jdField_a_of_type_Anlh != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      paramAdapterView = (EmotionPreviewInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (paramAdapterView.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Anlh.a())) {
        break label132;
      }
      i = 1;
      this.jdField_a_of_type_Anlh.a(paramAdapterView.jdField_a_of_type_JavaLangString);
      if (i != 0) {
        this.jdField_a_of_type_Anlh.notifyDataSetChanged();
      }
      paramView = this.jdField_a_of_type_Anlh.a();
      if ((paramView != null) && (!TextUtils.isEmpty(paramAdapterView.jdField_a_of_type_JavaLangString)))
      {
        i = paramView.indexOf(paramAdapterView.jdField_a_of_type_JavaLangString);
        if (i < 0) {
          break label138;
        }
        a(paramInt, i);
      }
    }
    for (;;)
    {
      b(paramInt + 1);
      return;
      label132:
      i = 0;
      break;
      label138:
      a(paramInt, -1);
    }
  }
  
  protected void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302804));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302847));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131310035));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131310053));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public boolean onBackEvent()
  {
    b();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i;
    switch (paramView.getId())
    {
    default: 
    case 2131302804: 
    case 2131310035: 
      EmotionPreviewInfo localEmotionPreviewInfo;
      boolean bool;
      do
      {
        do
        {
          return;
          b();
          return;
          i = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition();
        } while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (i >= this.jdField_a_of_type_JavaUtilArrayList.size()));
        localEmotionPreviewInfo = (EmotionPreviewInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localEmotionPreviewInfo.jdField_a_of_type_Boolean) {
          break;
        }
        bool = true;
        localEmotionPreviewInfo.jdField_a_of_type_Boolean = bool;
        this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(localEmotionPreviewInfo.jdField_a_of_type_Boolean);
        c();
      } while (this.jdField_a_of_type_Anlh == null);
      this.jdField_a_of_type_Anlh.a(localEmotionPreviewInfo.jdField_a_of_type_JavaLangString);
      paramView = this.jdField_a_of_type_Anlh.a();
      if (localEmotionPreviewInfo.jdField_a_of_type_Boolean) {
        paramView.add(localEmotionPreviewInfo.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        try
        {
          a(i, paramView.indexOf(localEmotionPreviewInfo.jdField_a_of_type_JavaLangString));
          if (paramView.size() != 0) {
            break label270;
          }
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
          this.jdField_a_of_type_Anlh.a(paramView);
          return;
          bool = false;
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("EmotionPreviewFragment", 2, "onClick exception = " + localException.getMessage());
          continue;
        }
        paramView.remove(localException.jdField_a_of_type_JavaLangString);
        continue;
        label270:
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
      }
    }
    paramView = new ArrayList();
    if (this.jdField_a_of_type_Anlh != null) {
      paramView = this.jdField_a_of_type_Anlh.a();
    }
    for (;;)
    {
      if (paramView.size() == 0)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition();
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (i < this.jdField_a_of_type_JavaUtilArrayList.size()))
        {
          localObject = (EmotionPreviewInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (!TextUtils.isEmpty(((EmotionPreviewInfo)localObject).jdField_a_of_type_JavaLangString)) {
            paramView.add(((EmotionPreviewInfo)localObject).jdField_a_of_type_JavaLangString);
          }
        }
      }
      awqx.b(null, "dc00898", "", "", "0X800A6DE", "0X800A6DE", 0, 0, String.valueOf(paramView.size()), "", "", "");
      Object localObject = new Intent();
      ((Intent)localObject).putStringArrayListExtra("PhotoConst.SELECTED_PATHS", paramView);
      getActivity().setResult(-1, (Intent)localObject);
      getActivity().finish();
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = a(paramLayoutInflater, paramViewGroup);
    b(paramLayoutInflater);
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPreviewFragment
 * JD-Core Version:    0.7.0.1
 */