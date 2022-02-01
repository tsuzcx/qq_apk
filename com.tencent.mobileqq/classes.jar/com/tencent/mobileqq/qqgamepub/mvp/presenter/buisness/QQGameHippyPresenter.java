package com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment;
import com.tencent.mobileqq.qqgamepub.hippy.view.GamePubAccountHeadAdapter;
import com.tencent.mobileqq.qqgamepub.mvp.model.buisness.QQGameHippyModel;
import com.tencent.mobileqq.qqgamepub.mvp.view.buisness.IQQGameHippyView;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.utils.UIUtils;
import com.tencent.mobileqq.qqgamepub.view.GameArkView;
import com.tencent.mobileqq.qqgamepub.view.IHeaderView;
import com.tencent.mobileqq.qqgamepub.view.MoreMsgHeaderView;
import com.tencent.mobileqq.qqgamepub.web.QQGameReportLogic;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QQGameHippyPresenter
  extends QQGameHippyBasePresenter<IQQGameHippyView, QQGameHippyModel>
{
  private final List<IHeaderView> i = new ArrayList();
  private GamePubAccountHeadAdapter j;
  @SuppressLint({"HandlerLeak"})
  private final Handler k = new QQGameHippyPresenter.1(this);
  
  private void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    if (this.e != null)
    {
      Message localMessage = new Message();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      this.k.sendMessage(localMessage);
    }
  }
  
  public void A()
  {
    GamePubAccountHeadAdapter localGamePubAccountHeadAdapter = this.j;
    if (localGamePubAccountHeadAdapter != null) {
      localGamePubAccountHeadAdapter.a(this.i, this.e);
    }
  }
  
  public boolean B()
  {
    return (this.d == 3) || (this.d == 4);
  }
  
  public List<IHeaderView> C()
  {
    return this.i;
  }
  
  public int D()
  {
    if (this.e == null) {
      return 0;
    }
    return this.e.size();
  }
  
  public int E()
  {
    GamePubAccountHeadAdapter localGamePubAccountHeadAdapter = this.j;
    if (localGamePubAccountHeadAdapter != null) {
      return localGamePubAccountHeadAdapter.getCount();
    }
    return 0;
  }
  
  public JSONObject a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    for (;;)
    {
      int m;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("gameData", GamePubAccountHelper.a(this.e));
        localJSONObject.put("headerHeight", 417);
        m = ((QQGameHippyModel)b()).b();
        int i1 = 0;
        int n = i1;
        Object localObject;
        if (m == 0)
        {
          localObject = GamePubAccountHelper.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface());
          m = 0;
          n = i1;
          if (m < this.e.size())
          {
            QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)this.e.get(m);
            if ((localQQGameMsgInfo.paMsgid == null) || (!localQQGameMsgInfo.paMsgid.equals(localObject))) {
              break label211;
            }
            n = m;
          }
        }
        localJSONObject.put("index", n);
        paramJSONObject.put("GpInitData", localJSONObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("feedEventJson=");
          ((StringBuilder)localObject).append(localJSONObject.toString());
          QLog.d("QQGamePub_QQGameHippyPresenter", 1, ((StringBuilder)localObject).toString());
          return paramJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return paramJSONObject;
      label211:
      m += 1;
    }
  }
  
  public void a(Context paramContext, GamePAHippyFragment paramGamePAHippyFragment)
  {
    this.j = new GamePubAccountHeadAdapter(this.i, this.e, paramContext, paramGamePAHippyFragment);
  }
  
  public void a(GmpEnterInfoRsp paramGmpEnterInfoRsp, boolean paramBoolean)
  {
    super.a(paramGmpEnterInfoRsp, paramBoolean);
    if (!c()) {
      return;
    }
    ((IQQGameHippyView)this.a.get()).a(paramGmpEnterInfoRsp, paramBoolean);
  }
  
  public void a(Object paramObject)
  {
    this.k.removeCallbacksAndMessages(paramObject);
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (!c()) {
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hippy,call handleAdReverseFeedBack arkViewId:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQGamePub_QQGameHippyPresenter", 1, ((StringBuilder)localObject).toString());
      localObject = (IQQGameHippyView)this.a.get();
      int m = 0;
      ((IQQGameHippyView)localObject).a(false, 0);
      if (this.e != null)
      {
        while (m < this.e.size())
        {
          if (paramString.equals(String.valueOf(((QQGameMsgInfo)this.e.get(m)).uniseq))) {
            break label136;
          }
          m += 1;
        }
        m = -1;
        label136:
        if ((m > -1) && (m < this.i.size()))
        {
          paramString = (IHeaderView)this.i.get(m);
          localObject = ((IQQGameHippyView)this.a.get()).g();
          if ((this.j != null) && (localObject != null))
          {
            int i1 = ((ViewPager)localObject).getCurrentItem();
            int n = i1;
            if (i1 == this.e.size() - 1) {
              n = i1 - 1;
            }
            this.i.remove(paramString);
            this.e.remove(m);
            ((IQQGameHippyView)this.a.get()).b(n);
            a(2, n, -1, GamePubAccountHelper.a(this.e).toString());
            a(1, n, -1, "");
          }
        }
      }
    }
  }
  
  public void a(ArrayList<QQGameMsgInfo> paramArrayList)
  {
    super.a(paramArrayList);
    if (!c()) {
      return;
    }
    ViewPager localViewPager = ((IQQGameHippyView)this.a.get()).g();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Object localObject = this.j;
      int m;
      if ((localObject != null) && (((GamePubAccountHeadAdapter)localObject).getCount() == 1)) {
        m = 1;
      } else {
        m = 0;
      }
      if (this.e == null) {
        return;
      }
      ((QQGameHippyModel)this.b).b(((QQGameHippyModel)this.b).c() + paramArrayList.size());
      ((QQGameHippyModel)this.b).c(((QQGameHippyModel)this.b).d() + paramArrayList.size());
      int n = 0;
      while (n < paramArrayList.size())
      {
        this.e.add(0, paramArrayList.get(n));
        localObject = ((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).createHeader((QQGameMsgInfo)paramArrayList.get(n), r());
        this.i.add(0, localObject);
        if (!TextUtils.isEmpty(((QQGameMsgInfo)paramArrayList.get(n)).arkAppName)) {
          this.f.add(((QQGameMsgInfo)paramArrayList.get(n)).arkAppName);
        }
        int i1;
        if (m != 0) {
          i1 = localViewPager.getCurrentItem();
        } else {
          i1 = localViewPager.getCurrentItem() + 1;
        }
        ((IQQGameHippyView)this.a.get()).b(i1);
        if (TextUtils.isEmpty(((QQGameMsgInfo)paramArrayList.get(n)).gameAppId)) {
          localObject = "";
        } else {
          localObject = ((QQGameMsgInfo)paramArrayList.get(n)).gameAppId;
        }
        String str = ((QQGameMsgInfo)paramArrayList.get(n)).paMsgid;
        w().a((String)localObject, str);
        n += 1;
      }
      paramArrayList = GamePubAccountHelper.a(this.e).toString();
      this.k.removeMessages(2);
      localObject = new Message();
      ((Message)localObject).what = 2;
      if (localViewPager != null) {
        m = localViewPager.getCurrentItem();
      } else {
        m = -1;
      }
      ((Message)localObject).arg1 = m;
      ((Message)localObject).arg2 = -1;
      ((Message)localObject).obj = paramArrayList;
      this.k.sendMessage((Message)localObject);
    }
  }
  
  public int b(int paramInt)
  {
    int m = paramInt;
    if (this.e != null)
    {
      m = paramInt;
      if (paramInt == this.e.size())
      {
        m = paramInt;
        if (paramInt > 0) {
          m = paramInt - 1;
        }
      }
    }
    return m;
  }
  
  public QQGameMsgInfo c(int paramInt)
  {
    if ((this.e != null) && (paramInt < this.e.size())) {
      return (QQGameMsgInfo)this.e.get(paramInt);
    }
    return null;
  }
  
  public void d(int paramInt)
  {
    try
    {
      Object localObject = c(paramInt);
      if ((paramInt == 0) && (localObject != null))
      {
        ((QQGameHippyModel)this.b).a((QQGameMsgInfo)localObject, 0, t());
        localObject = (IHeaderView)this.i.get(paramInt);
        if ((localObject instanceof GameArkView))
        {
          ((GameArkView)localObject).f();
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGamePub_QQGameHippyPresenter", 1, localThrowable.getMessage());
    }
  }
  
  public void e(int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    localMessage.arg1 = -1;
    localMessage.arg2 = ((int)UIUtils.a(paramInt, MobileQQ.sMobileQQ.getResources()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#### height:");
    localStringBuilder.append(localMessage.arg2);
    QLog.d("QQGamePub_QQGameHippyPresenter", 2, localStringBuilder.toString());
    this.k.sendMessage(localMessage);
  }
  
  public void f(int paramInt)
  {
    Object localObject;
    if ((this.e != null) && (paramInt < this.e.size()))
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 102;
      ((Message)localObject).arg1 = paramInt;
      this.k.removeMessages(102);
      this.k.sendMessageDelayed((Message)localObject, 200L);
    }
    if ((this.e != null) && (this.e.size() > 0))
    {
      if (paramInt >= this.e.size())
      {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGameHippyPresenter.2(this), 0L);
        return;
      }
      if (!c()) {
        return;
      }
      ((IQQGameHippyView)this.a.get()).d(paramInt);
      localObject = (QQGameMsgInfo)this.e.get(paramInt);
      GamePubAccountHelper.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), ((QQGameMsgInfo)localObject).paMsgid);
      ((QQGameHippyModel)this.b).a(paramInt, (QQGameMsgInfo)localObject, t());
      this.k.removeMessages(1);
      localObject = Message.obtain();
      ((Message)localObject).what = 1;
      ((Message)localObject).arg1 = paramInt;
      ((Message)localObject).arg2 = -1;
      ((Message)localObject).obj = "";
      this.k.sendMessage((Message)localObject);
    }
  }
  
  public void g()
  {
    super.g();
    try
    {
      a(null);
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        IHeaderView localIHeaderView = (IHeaderView)localIterator.next();
        if (localIHeaderView != null) {
          localIHeaderView.c();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGamePub_QQGameHippyPresenter", 1, localThrowable.getMessage());
    }
  }
  
  protected void n()
  {
    super.n();
    if (!c()) {
      return;
    }
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (QQGameMsgInfo)localIterator.next();
      localObject = ((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).createHeader((QQGameMsgInfo)localObject, r());
      this.i.add(localObject);
    }
    this.i.add(new MoreMsgHeaderView(r()));
  }
  
  protected int p()
  {
    return 3;
  }
  
  protected int q()
  {
    return 5;
  }
  
  public String t()
  {
    return "2";
  }
  
  protected QQGameHippyModel x()
  {
    return new QQGameHippyModel(this);
  }
  
  public int y()
  {
    if (((QQGameHippyModel)b()).b() == 0)
    {
      String str = GamePubAccountHelper.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface());
      int m = 0;
      while (m < this.e.size())
      {
        QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)this.e.get(m);
        if ((localQQGameMsgInfo != null) && (localQQGameMsgInfo.paMsgid != null) && (localQQGameMsgInfo.paMsgid.equals(str))) {
          return m;
        }
        m += 1;
      }
    }
    return 0;
  }
  
  public GamePubAccountHeadAdapter z()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyPresenter
 * JD-Core Version:    0.7.0.1
 */