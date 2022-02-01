package com.tencent.mobileqq.search.ftsentity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRespData;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ListView;
import java.util.List;

public class FTSEntitySearchDetailFragment
  extends BaseFragment
  implements Handler.Callback, ISearchListener<FTSEntitySearchResultDetailModel>
{
  private static List<FTSEntity> c;
  FTSEntitySearchDetailActivity a;
  FTSEntitySearchEngine b;
  private TextView d;
  private ListView e;
  private String f;
  private String g;
  private List<FTSEntity> h;
  private List<FTSEntitySearchResultDetailModel> i;
  private BaseMvpFTSEntityAdapter j;
  private IFaceDecoder k;
  private Handler l = new Handler(this);
  
  public static FTSEntitySearchDetailFragment a(String paramString1, String paramString2, List<FTSEntity> paramList)
  {
    c = paramList;
    paramList = new FTSEntitySearchDetailFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("original_keyword", paramString1);
    localBundle.putString("segment_keyword", paramString2);
    paramList.setArguments(localBundle);
    return paramList;
  }
  
  private void b(List<FTSEntitySearchResultDetailModel> paramList)
  {
    this.j.a(paramList);
  }
  
  public void a(List<FTSEntitySearchResultDetailModel> paramList) {}
  
  public void a(List<FTSEntitySearchResultDetailModel> paramList, int paramInt)
  {
    this.i = paramList;
    this.l.removeMessages(-1);
    this.l.sendEmptyMessage(-1);
  }
  
  public void a(List<FTSEntitySearchResultDetailModel> paramList, SearchRespData paramSearchRespData)
  {
    if (paramSearchRespData.a(this.f))
    {
      a(paramList, paramSearchRespData.b);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FTSEntitySearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramSearchRespData.a, " keyword2:", this.f });
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == -1) {
      b(this.i);
    }
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.h = c;
    c = null;
    paramBundle = getArguments();
    this.f = paramBundle.getString("original_keyword");
    this.g = paramBundle.getString("segment_keyword");
    this.a = ((FTSEntitySearchDetailActivity)getBaseActivity());
    this.b = FTSEntitySearchUtils.a(this.a.app, this.a.a);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131625297, paramViewGroup, false);
    this.d = ((TextView)paramLayoutInflater.findViewById(2131434940));
    this.e = ((ListView)paramLayoutInflater.findViewById(2131437272));
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    IFaceDecoder localIFaceDecoder = this.k;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
    c = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    try
    {
      paramView = FTSEntitySearchUtils.a(this.a, this.h.size(), this.f, this.a.a);
      this.d.setText(paramView);
      this.k = ((IQQAvatarService)this.a.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.a.app);
      this.j = new FTSEntitySearchDetailFragment.1(this, this.e, this.k, this.h, this.g, this.a);
      this.e.setAdapter(this.j);
      this.b.a(this.g, this.h);
      this.j.a();
      if ((this.f != null) && (this.f.length() > 0) && (!FTSMessageSearchEngine.a(this.f)))
      {
        this.b.a();
        paramView = FTSEntitySearchUtils.a(this.a.a, this.g, (FTSEntity)this.h.get(0));
        this.b.b(paramView, this);
        return;
      }
    }
    catch (NullPointerException paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FTSEntitySearchDetailFragment", 2, "onViewCreated: ", paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailFragment
 * JD-Core Version:    0.7.0.1
 */