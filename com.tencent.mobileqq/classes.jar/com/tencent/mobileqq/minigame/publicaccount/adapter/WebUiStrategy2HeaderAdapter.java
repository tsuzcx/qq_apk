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
      }
      return;
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
    if ((this.mMsgInfoList == null) || (this.mMsgInfoList.size() == 0))
    {
      localObject = createEmptyView();
      paramViewGroup.addView((View)localObject);
      paramViewGroup = (ViewGroup)localObject;
      return paramViewGroup;
    }
    Object localObject = (IHeaderView)this.mHeaderRecords.get(paramInt);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebUiStrategy2HeaderAdapter", 2, "headerView = null");
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebUiStrategy2HeaderAdapter", 2, "headerView = " + localObject.getClass().getSimpleName());
    }
    if (((View)localObject).getParent() != null) {
      ((ViewGroup)((View)localObject).getParent()).removeView((View)localObject);
    }
    if ((localObject instanceof GameArkView)) {
      modifyArkViewLayout((GameArkView)localObject, paramViewGroup, paramInt);
    }
    for (;;)
    {
      paramViewGroup = (ViewGroup)localObject;
      if (paramInt != 0) {
        break;
      }
      initArk(0);
      return localObject;
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      paramViewGroup.addView((View)localObject, localLayoutParams);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.adapter.WebUiStrategy2HeaderAdapter
 * JD-Core Version:    0.7.0.1
 */