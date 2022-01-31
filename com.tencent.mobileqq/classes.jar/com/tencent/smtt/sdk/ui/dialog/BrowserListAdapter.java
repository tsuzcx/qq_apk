package com.tencent.smtt.sdk.ui.dialog;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.stat.MttLoader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BrowserListAdapter
  extends ArrayAdapter<BrowsingActivityInfo>
  implements ListAdapter, View.OnClickListener
{
  private static final int ID_CHECK = 104;
  private static final int ID_CHECKED_BG = 106;
  private static final int ID_DETAIL = 103;
  private static final int ID_ICON = 101;
  private static final int ID_INNER_CONTAINER = 105;
  private static final int ID_LABEL = 102;
  private static final int ID_OPERATION = 107;
  private static final int ID_PROGRESSBAR = 108;
  private static final int MESSAGE_TYPE_REFRESH_RECOMMEND_ITEM = 1;
  public static final String MTT_PACKAGENAME = "com.tencent.mtt";
  private ArrayList<BrowsingActivityInfo> mActivityInfos;
  private ValueCallback<String> mCallback;
  private BrowsingActivityInfo mChecked = null;
  private WeakReference<TBSActivityPicker> mDialog;
  private Map<String, Drawable> mDrawables;
  private Handler mHandler;
  private Intent mIntent = null;
  private WeakReference<ListView> mListView;
  private BrowsingActivityInfo mRecommend;
  private BrowserListAdapter obj = this;
  private String[] recommendStringToTrim = null;
  
  public BrowserListAdapter(Context paramContext, Intent paramIntent, BrowsingActivityInfo paramBrowsingActivityInfo1, BrowsingActivityInfo paramBrowsingActivityInfo2, TBSActivityPicker paramTBSActivityPicker, ListView paramListView, ValueCallback<String> paramValueCallback)
  {
    super(paramContext, 0);
    setDialog(paramTBSActivityPicker);
    setListView(paramListView);
    this.mIntent = paramIntent;
    if (("com.tencent.rtxlite".equalsIgnoreCase(paramContext.getApplicationContext().getPackageName())) || (MttLoader.isBrowserInstalled(paramContext))) {}
    for (this.mRecommend = null;; this.mRecommend = paramBrowsingActivityInfo1)
    {
      this.mCallback = paramValueCallback;
      this.mHandler = new Handler()
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          switch (paramAnonymousMessage.what)
          {
          default: 
            return;
          }
          BrowserListAdapter.this.refreshRecommend();
        }
      };
      this.recommendStringToTrim = new String[2];
      this.recommendStringToTrim[0] = TBSResources.getString("x5_tbs_activity_picker_recommend_to_trim");
      this.recommendStringToTrim[1] = TBSResources.getString("x5_tbs_activity_picker_recommend_with_chinese_brace_to_trim");
      resetData(paramContext, paramBrowsingActivityInfo2);
      return;
    }
  }
  
  public static boolean checkApkExist(Context paramContext, String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return false;
    }
    try
    {
      paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  private View createWXLayout(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    localLinearLayout.setOrientation(1);
    Object localObject1 = new StateListDrawable();
    Object localObject2 = new ColorDrawable(Color.argb(41, 0, 0, 0));
    ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
    localObject2 = new ColorDrawable(0);
    ((StateListDrawable)localObject1).addState(new int[] { -16842919 }, (Drawable)localObject2);
    localLinearLayout.setBackgroundDrawable((Drawable)localObject1);
    localObject1 = new RelativeLayout(paramContext);
    ((RelativeLayout)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, dip2px(64.0F)));
    localObject2 = new ImageView(paramContext);
    Object localObject3 = new RelativeLayout.LayoutParams(dip2px(48.0F), dip2px(48.0F));
    ((RelativeLayout.LayoutParams)localObject3).addRule(9);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    int i = dip2px(8.0F);
    ((RelativeLayout.LayoutParams)localObject3).setMargins(i, i, i, i);
    ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((ImageView)localObject2).setId(101);
    ((RelativeLayout)localObject1).addView((View)localObject2);
    localObject2 = new LinearLayout(paramContext);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((RelativeLayout.LayoutParams)localObject3).addRule(1, 101);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((LinearLayout)localObject2).setOrientation(1);
    localObject3 = new TextView(paramContext);
    ((TextView)localObject3).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((TextView)localObject3).setMaxLines(1);
    ((TextView)localObject3).setTextColor(Color.rgb(29, 29, 29));
    ((TextView)localObject3).setTextSize(1, 17.0F);
    ((TextView)localObject3).setId(102);
    ((LinearLayout)localObject2).addView((View)localObject3);
    localObject3 = new TextView(paramContext);
    ((TextView)localObject3).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((TextView)localObject3).setText(TBSResources.getString("x5_tbs_wechat_activity_picker_label_recommend"));
    ((TextView)localObject3).setTextColor(Color.rgb(217, 217, 217));
    ((TextView)localObject3).setTextSize(1, 14.0F);
    ((TextView)localObject3).setId(103);
    ((LinearLayout)localObject2).addView((View)localObject3);
    ((RelativeLayout)localObject1).addView((View)localObject2);
    localObject2 = new ImageView(paramContext);
    localObject3 = new RelativeLayout.LayoutParams(dip2px(24.0F), dip2px(24.0F));
    ((RelativeLayout.LayoutParams)localObject3).addRule(11);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((RelativeLayout.LayoutParams)localObject3).setMargins(0, 0, dip2px(14.0F), 0);
    ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((ImageView)localObject2).setImageDrawable(TBSResources.getDrawable("x5_tbs_activity_picker_check"));
    ((ImageView)localObject2).setId(104);
    ((RelativeLayout)localObject1).addView((View)localObject2);
    paramContext = new Button(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(-2, dip2px(31.0F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(11);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 0, dip2px(8.0F), 0);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramContext.setTextColor(Color.rgb(50, 50, 50));
    paramContext.setTextSize(1, 14.0F);
    localObject2 = new StateListDrawable();
    float f = dip2px(2.0F);
    localObject3 = new RoundRectShape(new float[] { f, f, f, f, f, f, f, f }, null, null);
    ShapeDrawable localShapeDrawable = new ShapeDrawable((Shape)localObject3);
    localShapeDrawable.getPaint().setColor(Color.argb(128, 69, 192, 26));
    ((StateListDrawable)localObject2).addState(new int[] { -16842910 }, localShapeDrawable);
    localShapeDrawable = new ShapeDrawable((Shape)localObject3);
    localShapeDrawable.getPaint().setColor(Color.rgb(41, 132, 9));
    ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, localShapeDrawable);
    localObject3 = new ShapeDrawable((Shape)localObject3);
    ((ShapeDrawable)localObject3).getPaint().setColor(Color.rgb(69, 192, 26));
    ((StateListDrawable)localObject2).addState(new int[] { -16842919 }, (Drawable)localObject3);
    paramContext.setBackgroundDrawable((Drawable)localObject2);
    paramContext.setId(107);
    paramContext.setPadding(dip2px(8.0F), 0, dip2px(8.0F), 0);
    ((RelativeLayout)localObject1).addView(paramContext);
    ((RelativeLayout)localObject1).setId(105);
    localLinearLayout.addView((View)localObject1);
    return localLinearLayout;
  }
  
  private int dip2px(float paramFloat)
  {
    TBSActivityPicker localTBSActivityPicker = (TBSActivityPicker)this.mDialog.get();
    if (localTBSActivityPicker == null) {
      return (int)paramFloat;
    }
    return localTBSActivityPicker.dip2px(paramFloat);
  }
  
  private void enableOpenBrowserButtons(boolean paramBoolean)
  {
    if (this.mDialog == null) {}
    TBSActivityPicker localTBSActivityPicker;
    do
    {
      return;
      localTBSActivityPicker = (TBSActivityPicker)this.mDialog.get();
    } while (localTBSActivityPicker == null);
    localTBSActivityPicker.enableButtons(paramBoolean);
  }
  
  private void refreshView(BrowsingActivityInfo paramBrowsingActivityInfo, View paramView)
  {
    if ((paramView == null) || (paramBrowsingActivityInfo == null)) {
      return;
    }
    Object localObject1 = (ImageView)paramView.findViewById(101);
    TextView localTextView2 = (TextView)paramView.findViewById(102);
    TextView localTextView1 = (TextView)paramView.findViewById(103);
    ImageView localImageView = (ImageView)paramView.findViewById(104);
    View localView1 = paramView.findViewById(105);
    View localView2 = paramView.findViewById(106);
    Button localButton = (Button)paramView.findViewById(107);
    ProgressBar localProgressBar = (ProgressBar)paramView.findViewById(108);
    ((ImageView)localObject1).setImageDrawable(paramBrowsingActivityInfo.getIcon(this.mDrawables));
    localObject1 = paramBrowsingActivityInfo.getLabel().trim().replaceAll(' ' + "", "");
    String[] arrayOfString = this.recommendStringToTrim;
    int j = arrayOfString.length;
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      String str = arrayOfString[i];
      localObject2 = localObject1;
      if (str != null)
      {
        localObject2 = localObject1;
        if (str.length() > 0) {
          localObject2 = ((String)localObject1).replaceAll(str, "");
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    localTextView2.setText((CharSequence)localObject1);
    if (paramBrowsingActivityInfo.getResolveInfo() == null)
    {
      localObject1 = getContext().getPackageManager().queryIntentActivities(this.mIntent, 65536).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ResolveInfo)((Iterator)localObject1).next();
        if (paramBrowsingActivityInfo.getPackageName().equals(((ResolveInfo)localObject2).activityInfo.packageName)) {
          paramBrowsingActivityInfo.setResolveInfo((ResolveInfo)localObject2);
        }
      }
    }
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = paramAnonymousView.getParent();
        if ((paramAnonymousView == null) || (!(paramAnonymousView instanceof View))) {}
        do
        {
          return;
          paramAnonymousView = (View)paramAnonymousView;
        } while (paramAnonymousView.getTag() != BrowserListAdapter.this.mRecommend);
        BrowserListAdapter.this.onClick(paramAnonymousView);
      }
    });
    if ("com.tencent.mtt".equals(paramBrowsingActivityInfo.getPackageName()))
    {
      localTextView1.setVisibility(0);
      if (paramBrowsingActivityInfo.getResolveInfo() == null) {
        break label434;
      }
      localView1.setClickable(false);
      localView1.setEnabled(false);
      if (paramBrowsingActivityInfo != this.mChecked) {
        break label412;
      }
      localImageView.setVisibility(0);
      if (localView2 != null) {
        localView2.setVisibility(0);
      }
      label366:
      localButton.setVisibility(8);
      localButton.setOnClickListener(null);
      if (localProgressBar != null) {
        localProgressBar.setVisibility(8);
      }
    }
    for (;;)
    {
      paramView.setTag(paramBrowsingActivityInfo);
      paramView.setOnClickListener(this);
      return;
      localTextView1.setVisibility(8);
      break;
      label412:
      localImageView.setVisibility(8);
      if (localView2 == null) {
        break label366;
      }
      localView2.setVisibility(8);
      break label366;
      label434:
      localView1.setClickable(true);
      localView1.setEnabled(true);
      localImageView.setVisibility(8);
      if (localView2 != null) {
        localView2.setVisibility(8);
      }
      localButton.setVisibility(0);
      localButton.setText(TBSResources.getString("x5_tbs_wechat_activity_picker_label_download"));
      localButton.setEnabled(true);
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if ("com.tencent.mobileqq".equals(BrowserListAdapter.this.getContext().getApplicationContext().getPackageName()))
          {
            if (BrowserListAdapter.this.mCallback != null) {
              BrowserListAdapter.this.mCallback.onReceiveValue("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=11047");
            }
            ((TBSActivityPicker)BrowserListAdapter.this.mDialog.get()).dismiss();
            return;
          }
          paramAnonymousView = new Intent("android.intent.action.VIEW", Uri.parse("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=11041"));
          paramAnonymousView.addFlags(268435456);
          BrowserListAdapter.this.getContext().startActivity(paramAnonymousView);
        }
      });
    }
  }
  
  private void setChecked(Context paramContext, BrowsingActivityInfo paramBrowsingActivityInfo)
  {
    this.mChecked = paramBrowsingActivityInfo;
    if ((this.mChecked != null) && (checkApkExist(paramContext, paramBrowsingActivityInfo.getPackageName()))) {}
    for (boolean bool = true;; bool = false)
    {
      enableOpenBrowserButtons(bool);
      return;
    }
  }
  
  public BrowsingActivityInfo getCheckedActivityInfo()
  {
    return this.mChecked;
  }
  
  public int getCount()
  {
    return this.mActivityInfos.size();
  }
  
  public BrowsingActivityInfo getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mActivityInfos.size())) {
      return null;
    }
    return (BrowsingActivityInfo)this.mActivityInfos.get(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getItem(paramInt);
    if (paramViewGroup == null) {
      return null;
    }
    if (paramView != null) {}
    for (;;)
    {
      refreshView(paramViewGroup, paramView);
      return paramView;
      paramView = createWXLayout(getContext());
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    BrowsingActivityInfo localBrowsingActivityInfo1;
    if ((localObject != null) && ((localObject instanceof BrowsingActivityInfo)))
    {
      localBrowsingActivityInfo1 = (BrowsingActivityInfo)localObject;
      if (localBrowsingActivityInfo1 != this.mChecked) {}
    }
    else
    {
      return;
    }
    localObject = paramView.getParent();
    if ((localObject instanceof View)) {}
    for (localObject = (View)localObject;; localObject = null)
    {
      BrowsingActivityInfo localBrowsingActivityInfo2 = this.mChecked;
      setChecked(paramView.getContext(), localBrowsingActivityInfo1);
      refreshView(localBrowsingActivityInfo2, ((View)localObject).findViewWithTag(localBrowsingActivityInfo2));
      refreshView(this.mChecked, paramView);
      return;
    }
  }
  
  void refreshRecommend()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.mHandler.obtainMessage(1).sendToTarget();
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (ListView)this.mListView.get();
      } while (localObject == null);
      localObject = ((ListView)localObject).findViewWithTag(this.mRecommend);
    } while (localObject == null);
    refreshView(this.mRecommend, (View)localObject);
  }
  
  void resetData(Context paramContext, BrowsingActivityInfo paramBrowsingActivityInfo)
  {
    this.mActivityInfos = new ArrayList();
    Iterator localIterator = paramContext.getPackageManager().queryIntentActivities(this.mIntent, 65536).iterator();
    int i = 0;
    int j = 0;
    ResolveInfo localResolveInfo;
    BrowsingActivityInfo localBrowsingActivityInfo;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localResolveInfo = (ResolveInfo)localIterator.next();
        if ((BrowsingActivityInfo.getApkIcon(paramContext, localResolveInfo.activityInfo.packageName) != null) || (localResolveInfo.loadIcon(paramContext.getPackageManager()) != null))
        {
          localBrowsingActivityInfo = new BrowsingActivityInfo(paramContext, localResolveInfo);
          if ((this.mRecommend != null) && (this.mRecommend.getPackageName().equals(localResolveInfo.activityInfo.packageName)))
          {
            this.mActivityInfos.add(0, localBrowsingActivityInfo);
            j = 1;
            label139:
            if ((i != 0) || (paramBrowsingActivityInfo == null) || (!localBrowsingActivityInfo.getPackageName().equals(paramBrowsingActivityInfo.getPackageName()))) {
              break label271;
            }
            setChecked(paramContext, localBrowsingActivityInfo);
            i = 1;
          }
        }
      }
    }
    label271:
    for (;;)
    {
      break;
      if ("com.tencent.mtt".equals(localResolveInfo.activityInfo.packageName))
      {
        this.mActivityInfos.add(0, localBrowsingActivityInfo);
        break label139;
      }
      this.mActivityInfos.add(localBrowsingActivityInfo);
      break label139;
      if ((j == 0) && (this.mRecommend != null)) {
        this.mActivityInfos.add(0, this.mRecommend);
      }
      if ((i == 0) && (this.mActivityInfos.size() > 0)) {
        setChecked(paramContext, (BrowsingActivityInfo)this.mActivityInfos.get(0));
      }
      return;
    }
  }
  
  void setDialog(TBSActivityPicker paramTBSActivityPicker)
  {
    this.mDialog = new WeakReference(paramTBSActivityPicker);
  }
  
  void setListView(ListView paramListView)
  {
    this.mListView = new WeakReference(paramListView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.ui.dialog.BrowserListAdapter
 * JD-Core Version:    0.7.0.1
 */