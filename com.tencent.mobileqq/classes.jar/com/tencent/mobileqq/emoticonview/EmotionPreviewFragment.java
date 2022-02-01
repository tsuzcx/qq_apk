package com.tencent.mobileqq.emoticonview;

import adxr;
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
import bcef;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.emotionintegrate.EmotionGallery;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class EmotionPreviewFragment
  extends PublicBaseFragment
  implements View.OnClickListener, PreviewThumbAdapter.IThumbItemClickListener, AdapterView.OnItemSelectedListener
{
  public static final String PREVIEW_DATA = "preview_data";
  private static final String TAG = "EmotionPreviewFragment";
  private TextView leftText;
  private EmotionPreviewAdapter mAdapter;
  private EmotionGallery mGallery;
  private PreviewThumbAdapter mThumbAdapter;
  private NumberCheckBox numberCheckBox;
  private ArrayList<EmotionPreviewInfo> previewDataList;
  private RelativeLayout rightView;
  private HorizontalListView selectedPhotoListView;
  private Button sendButton;
  private RelativeLayout titleBar;
  private TextView titleText;
  private View topLineView;
  
  private void back()
  {
    Intent localIntent = getActivity().getIntent();
    localIntent.setClass(getActivity(), NewPhotoListActivity.class);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mThumbAdapter.getDataList());
    localIntent.addFlags(603979776);
    startActivity(localIntent);
    getActivity().finish();
  }
  
  public static void enterEmotionPreview(Activity paramActivity, Intent paramIntent, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramIntent != null))
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        EmotionPreviewInfo localEmotionPreviewInfo = new EmotionPreviewInfo();
        localEmotionPreviewInfo.path = str;
        localEmotionPreviewInfo.isCheck = true;
        localArrayList.add(localEmotionPreviewInfo);
      }
      paramIntent.putParcelableArrayListExtra("preview_data", localArrayList);
      adxr.a(paramActivity, paramIntent, PublicFragmentActivity.class, EmotionPreviewFragment.class, 100015);
    }
  }
  
  private int getPositionByPath(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.previewDataList != null) && (this.previewDataList.size() > 0))
    {
      int j = this.previewDataList.size();
      int i = 0;
      while (i < j)
      {
        if (((EmotionPreviewInfo)this.previewDataList.get(i)).path.equals(paramString)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  private int getSelectItemCount()
  {
    int j = 0;
    int i = j;
    if (this.previewDataList != null)
    {
      i = j;
      if (this.previewDataList.size() > 0)
      {
        Iterator localIterator = this.previewDataList.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          if (!((EmotionPreviewInfo)localIterator.next()).isCheck) {
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
  
  private void initData()
  {
    this.previewDataList = getActivity().getIntent().getParcelableArrayListExtra("preview_data");
    this.mAdapter.refreshData(this.previewDataList);
    if ((this.previewDataList != null) && (this.previewDataList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList(this.previewDataList.size());
      Iterator localIterator = this.previewDataList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((EmotionPreviewInfo)localIterator.next()).path);
      }
      this.mThumbAdapter = new PreviewThumbAdapter(getActivity(), this);
      this.selectedPhotoListView.setAdapter(this.mThumbAdapter);
      this.selectedPhotoListView.setVisibility(0);
      this.selectedPhotoListView.setOnItemClickListener(this.mThumbAdapter);
      this.selectedPhotoListView.setDividerWidth(AIOUtils.dp2px(14.0F, getResources()));
      this.mThumbAdapter.setData(localArrayList);
      this.mThumbAdapter.setCurrentPath(((EmotionPreviewInfo)this.previewDataList.get(0)).path);
    }
    refreshSendButton();
    refreshTitleView(1);
    refreshNumberCheckBox(0, 0);
  }
  
  private void refreshNumberCheckBox(int paramInt1, int paramInt2)
  {
    if ((this.numberCheckBox != null) && (this.previewDataList != null))
    {
      EmotionPreviewInfo localEmotionPreviewInfo = (EmotionPreviewInfo)this.previewDataList.get(paramInt1);
      this.numberCheckBox.setChecked(localEmotionPreviewInfo.isCheck);
      if ((localEmotionPreviewInfo.isCheck) && (paramInt2 >= 0)) {
        this.numberCheckBox.setCheckedNumber(paramInt2 + 1);
      }
    }
  }
  
  private void refreshSendButton()
  {
    int i;
    StringBuffer localStringBuffer;
    if (this.sendButton != null)
    {
      i = getSelectItemCount();
      localStringBuffer = new StringBuffer(getResources().getString(2131694460));
      if (i < 1) {
        this.sendButton.setText(localStringBuffer.toString());
      }
    }
    else
    {
      return;
    }
    this.sendButton.setText("(" + i + ")");
  }
  
  private void refreshTitleView(int paramInt)
  {
    if ((this.titleText != null) && (this.previewDataList != null) && (this.previewDataList.size() > 1)) {
      this.titleText.setText(paramInt + "/" + this.previewDataList.size());
    }
  }
  
  public View generateRootView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2131559149, paramViewGroup, false);
  }
  
  protected void initTitleBar(View paramView)
  {
    this.leftText = ((TextView)paramView.findViewById(2131369068));
    this.titleText = ((TextView)paramView.findViewById(2131369115));
    this.rightView = ((RelativeLayout)paramView.findViewById(2131377030));
    this.numberCheckBox = ((NumberCheckBox)paramView.findViewById(2131377052));
    this.leftText.setOnClickListener(this);
    this.rightView.setOnClickListener(this);
  }
  
  protected void initViewWithBusiness(View paramView)
  {
    this.sendButton = ((Button)paramView.findViewById(2131377075));
    this.sendButton.setOnClickListener(this);
    this.topLineView = paramView.findViewById(2131366941);
    this.titleBar = ((RelativeLayout)paramView.findViewById(2131378727));
    ((RelativeLayout.LayoutParams)this.titleBar.getLayoutParams()).topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
    this.mGallery = ((EmotionGallery)paramView.findViewById(2131367366));
    this.mAdapter = new EmotionPreviewAdapter(getActivity());
    this.mGallery.setAdapter(this.mAdapter);
    this.mGallery.setSpacing(getActivity().getResources().getDimensionPixelSize(2131297146));
    this.mGallery.setOnItemSelectedListener(this);
    this.mGallery.setOnNoBlankListener(this.mAdapter);
    this.mGallery.b(false);
    this.mGallery.a(false);
    this.selectedPhotoListView = ((HorizontalListView)paramView.findViewById(2131366942));
    initData();
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
    back();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i;
    switch (paramView.getId())
    {
    default: 
    case 2131369068: 
    case 2131377030: 
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
            back();
          }
          i = this.mGallery.getSelectedItemPosition();
        } while ((this.previewDataList == null) || (i >= this.previewDataList.size()));
        localEmotionPreviewInfo = (EmotionPreviewInfo)this.previewDataList.get(i);
        if (localEmotionPreviewInfo.isCheck) {
          break;
        }
        bool = true;
        localEmotionPreviewInfo.isCheck = bool;
        this.numberCheckBox.setChecked(localEmotionPreviewInfo.isCheck);
        refreshSendButton();
      } while (this.mThumbAdapter == null);
      this.mThumbAdapter.setCurrentPath(localEmotionPreviewInfo.path);
      localArrayList = this.mThumbAdapter.getDataList();
      if (localEmotionPreviewInfo.isCheck) {
        localArrayList.add(localEmotionPreviewInfo.path);
      }
      for (;;)
      {
        try
        {
          refreshNumberCheckBox(i, localArrayList.indexOf(localEmotionPreviewInfo.path));
          if (localArrayList.size() != 0) {
            break label286;
          }
          this.topLineView.setVisibility(8);
          this.selectedPhotoListView.setVisibility(8);
          this.mThumbAdapter.setData(localArrayList);
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
        localArrayList.remove(localException.path);
        continue;
        label286:
        this.topLineView.setVisibility(0);
        this.selectedPhotoListView.setVisibility(0);
      }
    }
    ArrayList localArrayList = new ArrayList();
    if (this.mThumbAdapter != null) {
      localArrayList = this.mThumbAdapter.getDataList();
    }
    for (;;)
    {
      if (localArrayList.size() == 0)
      {
        i = this.mGallery.getSelectedItemPosition();
        if ((this.previewDataList != null) && (i < this.previewDataList.size()))
        {
          localObject = (EmotionPreviewInfo)this.previewDataList.get(i);
          if (!TextUtils.isEmpty(((EmotionPreviewInfo)localObject).path)) {
            localArrayList.add(((EmotionPreviewInfo)localObject).path);
          }
        }
      }
      bcef.b(null, "dc00898", "", "", "0X800A6DE", "0X800A6DE", 0, 0, String.valueOf(localArrayList.size()), "", "", "");
      Object localObject = new Intent();
      ((Intent)localObject).putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
      getActivity().setResult(-1, (Intent)localObject);
      getActivity().finish();
      break;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = generateRootView(paramLayoutInflater, paramViewGroup);
    initTitleBar(paramLayoutInflater);
    initViewWithBusiness(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i;
    if ((this.mThumbAdapter != null) && (this.previewDataList != null) && (paramInt < this.previewDataList.size()))
    {
      paramAdapterView = (EmotionPreviewInfo)this.previewDataList.get(paramInt);
      if (paramAdapterView.path.equals(this.mThumbAdapter.getCurrentPath())) {
        break label132;
      }
      i = 1;
      this.mThumbAdapter.setCurrentPath(paramAdapterView.path);
      if (i != 0) {
        this.mThumbAdapter.notifyDataSetChanged();
      }
      paramView = this.mThumbAdapter.getDataList();
      if ((paramView != null) && (!TextUtils.isEmpty(paramAdapterView.path)))
      {
        i = paramView.indexOf(paramAdapterView.path);
        if (i < 0) {
          break label138;
        }
        refreshNumberCheckBox(paramInt, i);
      }
    }
    for (;;)
    {
      refreshTitleView(paramInt + 1);
      return;
      label132:
      i = 0;
      break;
      label138:
      refreshNumberCheckBox(paramInt, -1);
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void onThumbClick(int paramInt)
  {
    if (this.mThumbAdapter != null)
    {
      ArrayList localArrayList = this.mThumbAdapter.getDataList();
      if ((localArrayList != null) && (paramInt < localArrayList.size()))
      {
        int i = getPositionByPath((String)localArrayList.get(paramInt));
        if (i >= 0)
        {
          if (this.mGallery != null) {
            this.mGallery.setSelection(i);
          }
          refreshTitleView(i + 1);
          refreshNumberCheckBox(i, paramInt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPreviewFragment
 * JD-Core Version:    0.7.0.1
 */