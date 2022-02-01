package com.tencent.mobileqq.minigame.publicaccount.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ark.open.ArkView;
import com.tencent.mobileqq.minigame.publicaccount.model.QQGameMsgInfo;
import com.tencent.mobileqq.minigame.publicaccount.strategy.WebUiStrategy2.Strategy2Config;
import com.tencent.mobileqq.minigame.publicaccount.view.GameArkView;
import com.tencent.mobileqq.minigame.publicaccount.view.GameArkView.LoadGameArkCallback;
import com.tencent.mobileqq.minigame.publicaccount.view.IHeaderView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class WebUiStrategy2HeaderAdapter
  extends BaseHeaderAdapter
  implements GameArkView.LoadGameArkCallback
{
  private static final String TAG = "WebUiStrategy2HeaderAdapter";
  
  public WebUiStrategy2HeaderAdapter(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void insertArkTime(QQGameMsgInfo paramQQGameMsgInfo)
  {
    try
    {
      long l = new JSONObject(paramQQGameMsgInfo.arkAppConfig).optLong("ctime", -1L);
      if (l != -1L)
      {
        JSONObject localJSONObject1 = new JSONObject(paramQQGameMsgInfo.arkMetaList);
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("qqgame_model");
        if (localJSONObject2 != null) {
          localJSONObject2.put("msgTime", l);
        }
        paramQQGameMsgInfo.arkMetaList = localJSONObject1.toString();
        return;
      }
    }
    catch (JSONException paramQQGameMsgInfo)
    {
      QLog.w("WebUiStrategy2HeaderAdapter", 1, "insertArkTime fail:", paramQQGameMsgInfo);
    }
  }
  
  private void modifyArkViewLayout(GameArkView paramGameArkView, ViewGroup paramViewGroup, int paramInt)
  {
    paramGameArkView.setLoadCallback(this);
    paramViewGroup.addView(paramGameArkView, new RelativeLayout.LayoutParams(-1, -1));
    paramGameArkView = (FrameLayout.LayoutParams)paramGameArkView.getArkView().getLayoutParams();
    paramGameArkView.width = WebUiStrategy2.Strategy2Config.arkViewWidth;
    paramGameArkView.height = WebUiStrategy2.Strategy2Config.viewPagerItemHeight;
    paramGameArkView.leftMargin = WebUiStrategy2.Strategy2Config.viewPagerItemMarginLeft;
    paramGameArkView.gravity = 3;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public float getPageWidth(int paramInt)
  {
    return WebUiStrategy2.Strategy2Config.viewPagerWidth;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if ((this.mMsgInfoList != null) && (this.mMsgInfoList.size() != 0))
    {
      localObject1 = (IHeaderView)this.mHeaderRecords.get(paramInt);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebUiStrategy2HeaderAdapter", 2, "headerView = null");
        }
        return null;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("headerView = ");
        ((StringBuilder)localObject2).append(localObject1.getClass().getSimpleName());
        QLog.d("WebUiStrategy2HeaderAdapter", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = (View)localObject1;
      if (((View)localObject2).getParent() != null) {
        ((ViewGroup)((View)localObject2).getParent()).removeView((View)localObject2);
      }
      if ((localObject1 instanceof GameArkView)) {
        modifyArkViewLayout((GameArkView)localObject1, paramViewGroup, paramInt);
      } else {
        paramViewGroup.addView((View)localObject2, new RelativeLayout.LayoutParams(-2, -2));
      }
      if (paramInt == 0) {
        initArk(0);
      }
      return localObject1;
    }
    Object localObject1 = createEmptyView();
    paramViewGroup.addView((View)localObject1);
    return localObject1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onLoadFinish(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      initArk(paramInt2 + 1);
    }
  }
  
  public void setData(List<QQGameMsgInfo> paramList)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        insertArkTime((QQGameMsgInfo)localIterator.next());
      }
    }
    super.setData(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.adapter.WebUiStrategy2HeaderAdapter
 * JD-Core Version:    0.7.0.1
 */