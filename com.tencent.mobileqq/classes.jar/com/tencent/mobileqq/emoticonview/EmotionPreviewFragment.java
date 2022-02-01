package com.tencent.mobileqq.emoticonview;

import afez;
import agej;
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
import aspz;
import asrl;
import asrn;
import bdll;
import bljo;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.emotionintegrate.EmotionGallery;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class EmotionPreviewFragment
  extends PublicBaseFragment
  implements View.OnClickListener, asrn, bljo
{
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aspz jdField_a_of_type_Aspz;
  private asrl jdField_a_of_type_Asrl;
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
    this.jdField_a_of_type_Aspz.a(this.jdField_a_of_type_JavaUtilArrayList);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((EmotionPreviewInfo)localIterator.next()).jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Asrl = new asrl(getActivity(), this);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Asrl);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this.jdField_a_of_type_Asrl);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(agej.a(14.0F, getResources()));
      this.jdField_a_of_type_Asrl.a(localArrayList);
      this.jdField_a_of_type_Asrl.a(((EmotionPreviewInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString);
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
      afez.a(paramActivity, paramIntent, PublicFragmentActivity.class, EmotionPreviewFragment.class, 100015);
    }
  }
  
  private void b()
  {
    Intent localIntent = getActivity().getIntent();
    localIntent.setClass(getActivity(), NewPhotoListActivity.class);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Asrl.a());
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
      localStringBuffer = new StringBuffer(getResources().getString(2131694346));
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
    return paramLayoutInflater.inflate(2131559142, paramViewGroup, false);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Asrl != null)
    {
      ArrayList localArrayList = this.jdField_a_of_type_Asrl.a();
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
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131377324));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366918);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131378956));
    ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery = ((EmotionGallery)paramView.findViewById(2131367342));
    this.jdField_a_of_type_Aspz = new aspz(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setAdapter(this.jdField_a_of_type_Aspz);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setSpacing(getActivity().getResources().getDimensionPixelSize(2131297091));
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnItemSelectedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnNoBlankListener(this.jdField_a_of_type_Aspz);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.b(false);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a(false);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)paramView.findViewById(2131366919));
    a();
  }
  
  protected void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369042));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369088));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131377280));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131377301));
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
    case 2131369042: 
    case 2131377280: 
      EmotionPreviewInfo localEmotionPreviewInfo;
      boolean bool;
      do
      {
        do
        {
          for (;;)
          {
            EventCollector.getInstance().onViewClicked(paramView);
            return;
            b();
          }
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
      } while (this.jdField_a_of_type_Asrl == null);
      this.jdField_a_of_type_Asrl.a(localEmotionPreviewInfo.jdField_a_of_type_JavaLangString);
      localArrayList = this.jdField_a_of_type_Asrl.a();
      if (localEmotionPreviewInfo.jdField_a_of_type_Boolean) {
        localArrayList.add(localEmotionPreviewInfo.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        try
        {
          a(i, localArrayList.indexOf(localEmotionPreviewInfo.jdField_a_of_type_JavaLangString));
          if (localArrayList.size() != 0) {
            break label287;
          }
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
          this.jdField_a_of_type_Asrl.a(localArrayList);
          break;
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
        localArrayList.remove(localException.jdField_a_of_type_JavaLangString);
        continue;
        label287:
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
      }
    }
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_Asrl != null) {
      localArrayList = this.jdField_a_of_type_Asrl.a();
    }
    for (;;)
    {
      if (localArrayList.size() == 0)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition();
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (i < this.jdField_a_of_type_JavaUtilArrayList.size()))
        {
          localObject = (EmotionPreviewInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (!TextUtils.isEmpty(((EmotionPreviewInfo)localObject).jdField_a_of_type_JavaLangString)) {
            localArrayList.add(((EmotionPreviewInfo)localObject).jdField_a_of_type_JavaLangString);
          }
        }
      }
      bdll.b(null, "dc00898", "", "", "0X800A6DE", "0X800A6DE", 0, 0, String.valueOf(localArrayList.size()), "", "", "");
      Object localObject = new Intent();
      ((Intent)localObject).putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
      getActivity().setResult(-1, (Intent)localObject);
      getActivity().finish();
      break;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = a(paramLayoutInflater, paramViewGroup);
    b(paramLayoutInflater);
    a(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i;
    if ((this.jdField_a_of_type_Asrl != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      paramAdapterView = (EmotionPreviewInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (paramAdapterView.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Asrl.a())) {
        break label132;
      }
      i = 1;
      this.jdField_a_of_type_Asrl.a(paramAdapterView.jdField_a_of_type_JavaLangString);
      if (i != 0) {
        this.jdField_a_of_type_Asrl.notifyDataSetChanged();
      }
      paramView = this.jdField_a_of_type_Asrl.a();
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
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPreviewFragment
 * JD-Core Version:    0.7.0.1
 */