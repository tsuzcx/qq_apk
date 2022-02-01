package com.tencent.mobileqq.nearby.profilecard.moment;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ChangMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NearbyMomentFragment
  extends BaseFragment
  implements View.OnClickListener
{
  protected TextView a;
  public boolean b;
  private QQAppInterface c;
  private NearbyPeopleCard d;
  private ListView e;
  private boolean f = true;
  private int g;
  private NearbyProfileCardMomentAdapter h;
  private URLImageView i;
  private NearbyMomentFragment.FirstLoadDataCallback j;
  private boolean k;
  private TextView l;
  private boolean m;
  private int n;
  private final Map<String, MomentFeedInfo> o = new ConcurrentHashMap();
  private boolean p;
  private NearbyMomentFragment.OnLoadMomentListener q;
  private final NearbyMomentManager.MomentDataChangeObserver r = new NearbyMomentFragment.10(this);
  
  private MomentFeedInfo a(String paramString)
  {
    return (MomentFeedInfo)this.o.get(paramString);
  }
  
  private List<MomentFeedInfo> a(List<MomentFeedInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MomentFeedInfo localMomentFeedInfo = (MomentFeedInfo)paramList.next();
        if (a(localMomentFeedInfo.f) == null) {
          localArrayList.add(localMomentFeedInfo);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(NearbyMomentFragment.RefreshCallback paramRefreshCallback)
  {
    if ((this.d != null) && (this.c != null))
    {
      if (this.h.a().size() == 0) {
        a(0);
      } else {
        a(3);
      }
      this.o.clear();
      ((NearbyMomentManager)this.c.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).a(this.d.tinyId, this.d.nowId, this.d.nowUserType, 0, 20, new NearbyMomentFragment.2(this, paramRefreshCallback));
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, List<MomentFeedInfo> paramList, NearbyMomentFragment.RefreshCallback paramRefreshCallback)
  {
    if (paramBoolean1)
    {
      this.f = paramBoolean2;
      if (this.f)
      {
        this.l.setVisibility(0);
        this.l.setText(HardCodeUtil.a(2131905081));
      }
      this.g = paramInt;
      this.h.a(paramList);
      NearbyMomentFragment.FirstLoadDataCallback localFirstLoadDataCallback = this.j;
      if (localFirstLoadDataCallback != null) {
        localFirstLoadDataCallback.a(paramList.size());
      }
      if (paramRefreshCallback != null) {
        paramRefreshCallback.a(true, paramList);
      }
      if ((paramList != null) && (paramList.size() != 0))
      {
        a(3);
        return;
      }
      a(1);
      return;
    }
    a(2);
    if (paramRefreshCallback != null) {
      paramRefreshCallback.a(false, null);
    }
  }
  
  private MomentFeedInfo b(String paramString)
  {
    return (MomentFeedInfo)this.o.remove(paramString);
  }
  
  private void b(List<MomentFeedInfo> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (MomentFeedInfo)paramList.next();
        this.o.put(((MomentFeedInfo)localObject).f, localObject);
        if ((localObject instanceof ChangMomentFeedInfo))
        {
          localObject = (ChangMomentFeedInfo)localObject;
          this.o.put(((ChangMomentFeedInfo)localObject).a, localObject);
        }
      }
    }
  }
  
  private void g()
  {
    if ((this.d != null) && (this.c != null))
    {
      if (!this.k)
      {
        if (this.f) {
          return;
        }
        this.k = true;
        this.l.setVisibility(0);
        this.l.setText(HardCodeUtil.a(2131905073));
        ((NearbyMomentManager)this.c.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).a(this.d.tinyId, this.d.nowId, this.d.nowUserType, this.g, 20, new NearbyMomentFragment.3(this));
        return;
      }
      return;
    }
    QLog.i("NearbyMomentFragment", 1, "loadMore, mCard == null");
  }
  
  protected String a()
  {
    return "https://pub.idqqimg.com/pc/misc/files/20171226/fa8cc1bd068f40d08c3554d019ed445d.png";
  }
  
  public void a(int paramInt)
  {
    this.n = paramInt;
    int i1 = 1;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          this.i.setVisibility(8);
          this.a.setVisibility(8);
          this.e.setVisibility(0);
          paramInt = i1;
          break label502;
        }
        this.a.setVisibility(0);
        this.a.setOnClickListener(this);
        this.e.setVisibility(8);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)DeviceInfoUtil.F());
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = (((URLDrawable.URLDrawableOptions)localObject).mRequestWidth / 2);
        localObject = URLDrawable.getDrawable(c(), (URLDrawable.URLDrawableOptions)localObject);
        if (((URLDrawable)localObject).getStatus() == 1)
        {
          this.i.setImageDrawable((Drawable)localObject);
          this.i.setVisibility(0);
        }
        else
        {
          ((URLDrawable)localObject).setURLDrawableListener(new NearbyMomentFragment.8(this));
          ThreadManager.post(new NearbyMomentFragment.9(this, (URLDrawable)localObject), 8, null, false);
        }
        this.a.setText(HardCodeUtil.a(2131905077));
      }
      else
      {
        this.a.setVisibility(0);
        this.a.setOnClickListener(null);
        this.e.setVisibility(8);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)DeviceInfoUtil.F());
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = (((URLDrawable.URLDrawableOptions)localObject).mRequestWidth / 2);
        localObject = URLDrawable.getDrawable(a(), (URLDrawable.URLDrawableOptions)localObject);
        if (((URLDrawable)localObject).getStatus() == 1)
        {
          this.i.setVisibility(0);
          this.i.setImageDrawable((Drawable)localObject);
        }
        else
        {
          ((URLDrawable)localObject).setURLDrawableListener(new NearbyMomentFragment.6(this));
          ThreadManager.post(new NearbyMomentFragment.7(this, (URLDrawable)localObject), 8, null, false);
        }
        if (this.m) {
          this.a.setText(HardCodeUtil.a(2131905080));
        } else {
          this.a.setText(f());
        }
      }
      paramInt = 0;
    }
    else
    {
      this.a.setVisibility(0);
      this.a.setOnClickListener(null);
      this.e.setVisibility(8);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)DeviceInfoUtil.F());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = (((URLDrawable.URLDrawableOptions)localObject).mRequestWidth / 2);
      localObject = URLDrawable.getDrawable(b(), (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        this.i.setVisibility(0);
        this.i.setImageDrawable((Drawable)localObject);
      }
      else
      {
        ((URLDrawable)localObject).setURLDrawableListener(new NearbyMomentFragment.4(this));
        ThreadManager.post(new NearbyMomentFragment.5(this, (URLDrawable)localObject), 8, null, false);
      }
      this.a.setText(HardCodeUtil.a(2131905076));
      paramInt = i1;
    }
    label502:
    Object localObject = this.q;
    if ((localObject != null) && (paramInt == 0))
    {
      ((NearbyMomentFragment.OnLoadMomentListener)localObject).a();
      this.q = null;
    }
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard, NearbyMomentFragment.OnLoadMomentListener paramOnLoadMomentListener)
  {
    this.d = paramNearbyPeopleCard;
    this.q = paramOnLoadMomentListener;
    if (this.p)
    {
      this.h.a(this.d);
      a(null);
    }
  }
  
  public void a(NearbyMomentFragment.FirstLoadDataCallback paramFirstLoadDataCallback)
  {
    this.j = paramFirstLoadDataCallback;
  }
  
  protected String b()
  {
    return "https://pub.idqqimg.com/pc/misc/files/20171226/bab1a27be690414dbe509a7eaedecf4b.gif";
  }
  
  protected String c()
  {
    return "https://pub.idqqimg.com/pc/misc/files/20171226/0920780d51ba4d7aad487bb9bb8b18e6.png";
  }
  
  public View d()
  {
    return this.e;
  }
  
  public void e()
  {
    if (this.b)
    {
      a(null);
      this.b = false;
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = (NearbyMomentManager)((QQAppInterface)localObject).getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER);
      if (localObject != null) {
        ((NearbyMomentManager)localObject).a();
      }
    }
  }
  
  protected String f()
  {
    NearbyPeopleCard localNearbyPeopleCard = this.d;
    int i1;
    if ((localNearbyPeopleCard != null) && (localNearbyPeopleCard.gender == 1)) {
      i1 = 2131905082;
    } else {
      i1 = 2131905074;
    }
    return HardCodeUtil.a(i1);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.c = ((BaseActivity)paramActivity).app;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131448426) {
      return;
    }
    a(null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if ((paramViewGroup != null) && (this.c != null))
    {
      if (this.d == null) {
        return null;
      }
      paramLayoutInflater = paramLayoutInflater.inflate(2131625508, null);
      this.e = ((ListView)paramLayoutInflater.findViewById(2131438799));
      this.a = ((TextView)paramLayoutInflater.findViewById(2131448426));
      this.i = ((URLImageView)paramLayoutInflater.findViewById(2131449069));
      this.h = new NearbyProfileCardMomentAdapter(paramViewGroup.getContext(), this.c);
      this.h.a(this.d);
      paramBundle = (LinearLayout.LayoutParams)this.i.getLayoutParams();
      paramBundle.width = ((int)DeviceInfoUtil.F());
      paramBundle.height = (paramBundle.width / 2);
      this.l = new TextView(paramViewGroup.getContext());
      paramBundle = new AbsListView.LayoutParams(-1, -2);
      this.l.setLayoutParams(paramBundle);
      this.l.setTextColor(-16777216);
      this.l.setBackgroundColor(-1);
      this.l.setGravity(17);
      this.l.setPadding(0, UIUtils.a(paramViewGroup.getContext(), 10.0F), 0, UIUtils.a(paramViewGroup.getContext(), 10.0F));
      this.l.setTextSize(14.0F);
      this.m = this.d.isHostSelf;
      if (!this.m)
      {
        paramViewGroup = (FrameLayout.LayoutParams)this.e.getLayoutParams();
        paramViewGroup.bottomMargin = UIUtils.a(BaseApplicationImpl.getContext(), 68.0F);
        this.e.setLayoutParams(paramViewGroup);
      }
      this.e.addFooterView(this.l);
      this.l.setVisibility(8);
      this.e.setAdapter(this.h);
      this.e.setOnScrollListener(new NearbyMomentFragment.1(this));
      this.p = true;
      a(null);
      ((NearbyMomentManager)this.c.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).a(this.r);
      return paramLayoutInflater;
    }
    return null;
  }
  
  public void onDestroyView()
  {
    QQAppInterface localQQAppInterface = this.c;
    if (localQQAppInterface != null) {
      ((NearbyMomentManager)localQQAppInterface.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).b(this.r);
    }
    this.o.clear();
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment
 * JD-Core Version:    0.7.0.1
 */