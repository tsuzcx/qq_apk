package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emoticonview.api.IEmotionPreviewService;
import com.tencent.mobileqq.emotionintegrate.EmotionGallery;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class EmotionPreviewFragment
  extends PublicBaseFragment
  implements View.OnClickListener, IPreviewThumbAdapter.IThumbItemClickListener, AdapterView.OnItemSelectedListener
{
  public static final String PREVIEW_DATA = "preview_data";
  private static final String TAG = "EmotionPreviewFragment";
  private TextView leftText;
  private EmotionPreviewAdapter mAdapter;
  private EmotionGallery mGallery;
  private IPreviewThumbAdapter mThumbAdapter;
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
    Intent localIntent = getBaseActivity().getIntent();
    localIntent.setClass(getBaseActivity(), NewPhotoListActivity.class);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mThumbAdapter.getDataList());
    localIntent.addFlags(603979776);
    startActivity(localIntent);
    getBaseActivity().finish();
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
      PublicFragmentActivity.Launcher.a(paramActivity, paramIntent, PublicFragmentActivity.class, EmotionPreviewFragment.class, 10015);
    }
  }
  
  private int getPositionByPath(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ArrayList localArrayList = this.previewDataList;
      if ((localArrayList != null) && (localArrayList.size() > 0))
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
    }
    return -1;
  }
  
  private int getSelectItemCount()
  {
    Object localObject = this.previewDataList;
    int k = 0;
    int i = 0;
    int j = k;
    if (localObject != null)
    {
      j = k;
      if (((ArrayList)localObject).size() > 0)
      {
        localObject = this.previewDataList.iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          if (((EmotionPreviewInfo)((Iterator)localObject).next()).isCheck) {
            i += 1;
          }
        }
      }
    }
    return j;
  }
  
  private void initData()
  {
    this.previewDataList = getBaseActivity().getIntent().getParcelableArrayListExtra("preview_data");
    this.mAdapter.refreshData(this.previewDataList);
    ArrayList localArrayList = this.previewDataList;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localArrayList = new ArrayList(this.previewDataList.size());
      Iterator localIterator = this.previewDataList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((EmotionPreviewInfo)localIterator.next()).path);
      }
      this.mThumbAdapter = ((IEmotionPreviewService)QRoute.api(IEmotionPreviewService.class)).createPreviewThumbAdapter(getBaseActivity(), this);
      this.selectedPhotoListView.setAdapter(this.mThumbAdapter);
      this.selectedPhotoListView.setVisibility(0);
      this.selectedPhotoListView.setOnItemClickListener(this.mThumbAdapter);
      this.selectedPhotoListView.setDividerWidth(AIOUtils.b(14.0F, getResources()));
      this.mThumbAdapter.setData(localArrayList);
      this.mThumbAdapter.setCurrentPath(((EmotionPreviewInfo)this.previewDataList.get(0)).path);
    }
    refreshSendButton();
    refreshTitleView(1);
    refreshNumberCheckBox(0, 0);
  }
  
  private void refreshNumberCheckBox(int paramInt1, int paramInt2)
  {
    if (this.numberCheckBox != null)
    {
      Object localObject = this.previewDataList;
      if (localObject != null)
      {
        localObject = (EmotionPreviewInfo)((ArrayList)localObject).get(paramInt1);
        this.numberCheckBox.setChecked(((EmotionPreviewInfo)localObject).isCheck);
        if ((((EmotionPreviewInfo)localObject).isCheck) && (paramInt2 >= 0)) {
          this.numberCheckBox.setCheckedNumber(paramInt2 + 1);
        }
      }
    }
  }
  
  private void refreshSendButton()
  {
    if (this.sendButton != null)
    {
      int i = getSelectItemCount();
      StringBuffer localStringBuffer = new StringBuffer(getResources().getString(2131892590));
      if (i < 1)
      {
        this.sendButton.setText(localStringBuffer.toString());
        return;
      }
      Button localButton = this.sendButton;
      localStringBuffer.append("(");
      localStringBuffer.append(i);
      localStringBuffer.append(")");
      localButton.setText(localStringBuffer.toString());
    }
  }
  
  private void refreshTitleView(int paramInt)
  {
    if (this.titleText != null)
    {
      Object localObject = this.previewDataList;
      if ((localObject != null) && (((ArrayList)localObject).size() > 1))
      {
        localObject = this.titleText;
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(paramInt);
        localStringBuffer.append("/");
        localStringBuffer.append(this.previewDataList.size());
        ((TextView)localObject).setText(localStringBuffer.toString());
      }
    }
  }
  
  public View generateRootView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2131624751, paramViewGroup, false);
  }
  
  protected void initTitleBar(View paramView)
  {
    this.leftText = ((TextView)paramView.findViewById(2131436180));
    this.titleText = ((TextView)paramView.findViewById(2131436227));
    this.rightView = ((RelativeLayout)paramView.findViewById(2131445529));
    this.numberCheckBox = ((NumberCheckBox)paramView.findViewById(2131445553));
    this.leftText.setOnClickListener(this);
    this.rightView.setOnClickListener(this);
  }
  
  protected void initViewWithBusiness(View paramView)
  {
    this.sendButton = ((Button)paramView.findViewById(2131445580));
    this.sendButton.setOnClickListener(this);
    this.topLineView = paramView.findViewById(2131433483);
    this.titleBar = ((RelativeLayout)paramView.findViewById(2131447484));
    ((RelativeLayout.LayoutParams)this.titleBar.getLayoutParams()).topMargin = ImmersiveUtils.getStatusBarHeight(getBaseActivity());
    this.mGallery = ((EmotionGallery)paramView.findViewById(2131433934));
    this.mAdapter = new EmotionPreviewAdapter(getBaseActivity());
    this.mGallery.setAdapter(this.mAdapter);
    this.mGallery.setSpacing(getBaseActivity().getResources().getDimensionPixelSize(2131297535));
    this.mGallery.setOnItemSelectedListener(this);
    this.mGallery.setOnNoBlankListener(this.mAdapter);
    this.mGallery.enableDoubleTap(false);
    this.mGallery.enableScaleGesture(false);
    this.selectedPhotoListView = ((HorizontalListView)paramView.findViewById(2131433484));
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
    int i = paramView.getId();
    if (i != 2131436180)
    {
      Object localObject1;
      Object localObject2;
      if (i != 2131445529)
      {
        if (i == 2131445580)
        {
          localObject1 = new ArrayList();
          localObject2 = this.mThumbAdapter;
          if (localObject2 != null) {
            localObject1 = ((IPreviewThumbAdapter)localObject2).getDataList();
          }
          if (((ArrayList)localObject1).size() == 0)
          {
            i = this.mGallery.getSelectedItemPosition();
            localObject2 = this.previewDataList;
            if ((localObject2 != null) && (i < ((ArrayList)localObject2).size()))
            {
              localObject2 = (EmotionPreviewInfo)this.previewDataList.get(i);
              if (!TextUtils.isEmpty(((EmotionPreviewInfo)localObject2).path)) {
                ((ArrayList)localObject1).add(((EmotionPreviewInfo)localObject2).path);
              }
            }
          }
          ReportController.b(null, "dc00898", "", "", "0X800A6DE", "0X800A6DE", 0, 0, String.valueOf(((ArrayList)localObject1).size()), "", "", "");
          localObject2 = new Intent();
          ((Intent)localObject2).putStringArrayListExtra("PhotoConst.SELECTED_PATHS", (ArrayList)localObject1);
          getBaseActivity().setResult(-1, (Intent)localObject2);
          getBaseActivity().finish();
        }
      }
      else
      {
        i = this.mGallery.getSelectedItemPosition();
        localObject1 = this.previewDataList;
        if ((localObject1 != null) && (i < ((ArrayList)localObject1).size()))
        {
          localObject2 = (EmotionPreviewInfo)this.previewDataList.get(i);
          ((EmotionPreviewInfo)localObject2).isCheck ^= true;
          this.numberCheckBox.setChecked(((EmotionPreviewInfo)localObject2).isCheck);
          refreshSendButton();
          localObject1 = this.mThumbAdapter;
          if (localObject1 != null)
          {
            ((IPreviewThumbAdapter)localObject1).setCurrentPath(((EmotionPreviewInfo)localObject2).path);
            localObject1 = this.mThumbAdapter.getDataList();
            if (((EmotionPreviewInfo)localObject2).isCheck)
            {
              ((ArrayList)localObject1).add(((EmotionPreviewInfo)localObject2).path);
              try
              {
                refreshNumberCheckBox(i, ((ArrayList)localObject1).indexOf(((EmotionPreviewInfo)localObject2).path));
              }
              catch (Exception localException)
              {
                if (!QLog.isColorLevel()) {
                  break label393;
                }
              }
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("onClick exception = ");
              localStringBuilder.append(localException.getMessage());
              QLog.d("EmotionPreviewFragment", 2, localStringBuilder.toString());
            }
            else
            {
              ((ArrayList)localObject1).remove(localException.path);
            }
            label393:
            if (((ArrayList)localObject1).size() == 0)
            {
              this.topLineView.setVisibility(8);
              this.selectedPhotoListView.setVisibility(8);
            }
            else
            {
              this.topLineView.setVisibility(0);
              this.selectedPhotoListView.setVisibility(0);
            }
            this.mThumbAdapter.setData((ArrayList)localObject1);
          }
        }
      }
    }
    else
    {
      back();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = generateRootView(paramLayoutInflater, paramViewGroup);
    initTitleBar(paramLayoutInflater);
    initViewWithBusiness(paramLayoutInflater);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.mThumbAdapter != null)
    {
      paramAdapterView = this.previewDataList;
      if ((paramAdapterView != null) && (paramInt < paramAdapterView.size()))
      {
        paramAdapterView = (EmotionPreviewInfo)this.previewDataList.get(paramInt);
        boolean bool = paramAdapterView.path.equals(this.mThumbAdapter.getCurrentPath());
        this.mThumbAdapter.setCurrentPath(paramAdapterView.path);
        if ((bool ^ true)) {
          this.mThumbAdapter.notifyDataSetChanged();
        }
        paramView = this.mThumbAdapter.getDataList();
        if ((paramView != null) && (!TextUtils.isEmpty(paramAdapterView.path)))
        {
          int i = paramView.indexOf(paramAdapterView.path);
          if (i >= 0) {
            refreshNumberCheckBox(paramInt, i);
          } else {
            refreshNumberCheckBox(paramInt, -1);
          }
        }
      }
    }
    refreshTitleView(paramInt + 1);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void onThumbClick(int paramInt)
  {
    Object localObject = this.mThumbAdapter;
    if (localObject != null)
    {
      localObject = ((IPreviewThumbAdapter)localObject).getDataList();
      if ((localObject != null) && (paramInt < ((ArrayList)localObject).size()))
      {
        int i = getPositionByPath((String)((ArrayList)localObject).get(paramInt));
        if (i >= 0)
        {
          localObject = this.mGallery;
          if (localObject != null) {
            ((EmotionGallery)localObject).setSelection(i);
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