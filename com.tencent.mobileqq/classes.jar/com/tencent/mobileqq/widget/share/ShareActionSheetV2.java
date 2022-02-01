package com.tencent.mobileqq.widget.share;

import amvi;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aozt;
import aozx;
import bbyp;
import bcef;
import bjnw;
import bjon;
import bjuk;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zjv;

public class ShareActionSheetV2
  implements ShareActionSheet
{
  private static final String TAG = "ShareActionSheetV2";
  protected ImageView cancel;
  protected CharSequence dialogTitle;
  protected GridView grid_row_view0;
  protected GridView grid_row_view1;
  protected GridView grid_row_view2;
  protected int itemImageSize;
  protected int itemMargin;
  protected int itemTextMargin;
  protected int itemTextWidth;
  protected List<ShareActionSheetBuilder.ActionSheetItem>[] mActionSheetItems;
  protected LinearLayout mActionSheetLin;
  private View mActionSheetPanel;
  protected List<ShareActionSheetBuilder.ActionSheetItem> mActionSheetRecentUserItems = new ArrayList(0);
  private Application.ActivityLifecycleCallbacks mActivityLifecycleCallback = new ShareActionSheetV2.3(this);
  protected ShareActionSheetV2.AdViewManager mAdViewManager;
  protected LinearLayout mBottomBar;
  private ShareActionSheet.IShareActionSheetV2BottomBar mBottomBarInterface;
  private DialogInterface.OnCancelListener mCancelListener = new ShareActionSheetV2.6(this);
  protected AdapterView.OnItemClickListener mClickListener = new ShareActionSheetV2.1(this);
  private DialogInterface.OnCancelListener mClientCancelListener;
  private DialogInterface.OnDismissListener mClientDismissListener;
  private DialogInterface.OnShowListener mClientOnShowListener;
  protected bjnw mDialog;
  private DialogInterface.OnDismissListener mDismissListener = new ShareActionSheetV2.4(this);
  private boolean mEnableNotTriggerVirtualNavigationBar;
  private aozx mFaceObserver = new ShareActionSheetV2.2(this);
  protected int mGridView0Length;
  protected int mGridView1Length;
  protected int mGridView2Length;
  private SparseArray<aozt> mHeaderLoader;
  private Intent mIntentForStartForwardRecentActivity;
  protected boolean mIsDataChanged;
  private boolean mIsPendingShow;
  private ShareActionSheet.OnItemClickListener mItemClickListener;
  private DialogInterface.OnShowListener mOnShowListener = new ShareActionSheetV2.5(this);
  public Context mOutAct;
  private final ShareActionSheetV2.Param mParam;
  private ResultReceiver mRecentUserActivityReceiver;
  private int mRowFriendsVisibility = 0;
  private int mRowOperationsVisibility = 0;
  private int mRowPathsVisibility = 0;
  protected ElasticHorScrView mScrollView0;
  protected ElasticHorScrView mScrollView1;
  protected ElasticHorScrView mScrollView2;
  protected View mShowView;
  protected TextView mTitleTv;
  private String openSource;
  protected int scrollViewMargin;
  protected boolean showTitle = true;
  protected int textSpacingExtra;
  
  public ShareActionSheetV2(ShareActionSheetV2.Param paramParam)
  {
    this.mParam = paramParam;
    this.mOutAct = paramParam.context;
    paramParam = this.mOutAct.getResources();
    this.itemImageSize = paramParam.getDimensionPixelSize(2131296795);
    this.itemTextWidth = this.itemImageSize;
    this.itemTextMargin = paramParam.getDimensionPixelOffset(2131296797);
    this.textSpacingExtra = paramParam.getDimensionPixelOffset(2131296798);
    this.mAdViewManager = new ShareActionSheetV2.AdViewManager();
    int i = paramParam.getDisplayMetrics().widthPixels;
    int j = paramParam.getDisplayMetrics().heightPixels;
    if (i > j) {
      i = j;
    }
    for (;;)
    {
      i = (i - (int)(getIconWidth() * 5.2F)) / (((int)5.2F + 1) * 2);
      setIconMarginLeftRight(i);
      setRowMarginLeftRight((int)(i * 6 / 5.5F));
      registerActivityLifecycle();
      return;
    }
  }
  
  protected static String breakLabel(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > paramInt) {
        str = paramString.substring(0, paramInt) + "\n" + paramString.substring(paramInt);
      }
    }
    return str;
  }
  
  protected static String breakLabel2(TextPaint paramTextPaint, float paramFloat, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    String str;
    do
    {
      do
      {
        return paramString;
        i = findMaxCharCntPerLine(paramTextPaint, paramString, paramFloat);
        if (!amvi.a()) {
          break;
        }
        paramInt = Math.min(paramInt, i);
      } while (paramString.length() <= paramInt);
      str = paramString.substring(0, paramInt);
      paramString = paramString.substring(paramInt);
      paramInt = findMaxCharCntPerLine(paramTextPaint, paramString, paramFloat);
      paramTextPaint = paramString;
      if (paramString.length() > paramInt) {
        paramTextPaint = paramString.substring(0, paramInt) + "..";
      }
      return str + "\n" + paramTextPaint;
    } while (paramString.length() <= i);
    paramTextPaint = new StringBuilder();
    paramString = paramString.split(" ");
    int j = paramString.length;
    paramInt = 0;
    for (;;)
    {
      int k;
      if (paramInt < j)
      {
        str = paramString[paramInt];
        k = paramTextPaint.toString().length() + str.length();
        if (k <= i * 2) {}
      }
      else
      {
        paramString = paramTextPaint.toString().trim();
        paramTextPaint = paramString;
        if (paramString.length() > i * 2) {
          paramTextPaint = paramString.substring(0, i) + "..";
        }
        return paramTextPaint;
      }
      if ((!paramTextPaint.toString().contains("\n")) && (k > i)) {
        paramTextPaint.append("\n");
      }
      paramTextPaint.append(str).append(" ");
      paramInt += 1;
    }
  }
  
  private void createDialog()
  {
    if (this.mParam.fullScreen) {}
    int i;
    for (this.mDialog = ((bjnw)bjon.b(this.mOutAct, null));; this.mDialog = ((bjnw)bjon.a(this.mOutAct, null, i, this.mParam.lp)))
    {
      this.mDialog.setOnShowListener(this.mOnShowListener);
      this.mDialog.a(new ShareActionSheetV2.7(this));
      this.mDialog.setOnCancelListener(this.mCancelListener);
      if ((this.mShowView == null) || (this.mIsDataChanged)) {
        this.mShowView = createViewFlipper();
      }
      this.mDialog.a(this.mShowView, null);
      Window localWindow = this.mDialog.getWindow();
      localWindow.setDimAmount(this.mParam.dimAmount);
      localWindow.setGravity(80);
      localWindow.setLayout(-1, -1);
      this.mDialog.d(this.mParam.canceledOnTouchOutside);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      if (this.mParam.flagNotTouchModal) {
        localWindow.setLayout(-1, -2);
      }
      if (this.mParam.flagNotTouchModal) {
        localWindow.setFlags(32, 32);
      }
      localWindow.setAttributes(localLayoutParams);
      return;
      i = 2131558436;
      if (this.mParam.flagNotTouchModal) {
        i = 2131558437;
      }
    }
  }
  
  private void destroyRecentUserTask()
  {
    if (this.mRecentUserActivityReceiver != null)
    {
      this.mRecentUserActivityReceiver.send(1, new Bundle());
      this.mRecentUserActivityReceiver = null;
    }
  }
  
  private void dismissInternal(boolean paramBoolean)
  {
    setOpenSource(null);
    if (isShowing())
    {
      if (paramBoolean) {}
      for (;;)
      {
        try
        {
          this.mDialog.e();
          this.mShowView = null;
          return;
        }
        catch (RuntimeException localRuntimeException)
        {
          QLog.w("ShareActionSheetV2", 2, "Exception while dismiss", localRuntimeException);
        }
        this.mDialog.dismiss();
      }
    }
  }
  
  private static int findMaxCharCntPerLine(TextPaint paramTextPaint, String paramString, float paramFloat)
  {
    int j;
    if (paramTextPaint.measureText(paramString) < paramFloat)
    {
      j = paramString.length();
      return j;
    }
    int i = 1;
    for (;;)
    {
      if (i > paramString.length()) {
        break label54;
      }
      j = i;
      if (paramTextPaint.measureText(paramString.substring(0, i)) > paramFloat) {
        break;
      }
      i += 1;
    }
    label54:
    return paramString.length();
  }
  
  private String getGeneralUrlSourceKey()
  {
    if (!TextUtils.isEmpty(((Activity)this.mOutAct).getIntent().getStringExtra("url"))) {
      return "biz_src_general_url";
    }
    return "";
  }
  
  private String getReportR2()
  {
    if ((this.mParam != null) && (this.mParam.reportDataR2 > 0)) {
      return String.valueOf(this.mParam.reportDataR2);
    }
    return "";
  }
  
  private int getTextMeasuredHeight(List<ShareActionSheetBuilder.ActionSheetItem> paramList, TextView paramTextView)
  {
    paramTextView.setText(getLongestLabel(paramList));
    paramTextView.measure(View.MeasureSpec.makeMeasureSpec(this.itemTextWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    return paramTextView.getMeasuredHeight();
  }
  
  private void loadRecentUsersAsync()
  {
    destroyRecentUserTask();
    Intent localIntent = new Intent();
    if (this.mIntentForStartForwardRecentActivity != null) {
      localIntent = this.mIntentForStartForwardRecentActivity;
    }
    localIntent.putExtra("direct_send_if_dataline_forward", true);
    localIntent.setClass(this.mOutAct, ForwardRecentTranslucentActivity.class);
    localIntent.putExtra("caller_name", this.mOutAct.getClass().getSimpleName());
    localIntent.putExtra("forward_source_business_type", -1);
    localIntent.putExtra("key_req", ForwardRecentActivity.g);
    localIntent.putExtra("PARAM_ActivityResultReceiver", new ShareActionSheetV2.MyResultReceiver(this));
    this.mOutAct.startActivity(localIntent);
    ((Activity)this.mOutAct).overridePendingTransition(0, 0);
  }
  
  private boolean needLoadRecentUser()
  {
    if (this.mRowFriendsVisibility != 0) {
      if (QLog.isColorLevel()) {
        QLog.d("ShareActionSheetV2", 2, "needLoadRecentUser() called no need to load data");
      }
    }
    do
    {
      return false;
      if (this.mIntentForStartForwardRecentActivity != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShareActionSheetV2", 2, "needLoadRecentUser() called parameter illegal. Intent not set");
    return false;
    return true;
  }
  
  private void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "onDestroy() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    if ((this.mHeaderLoader != null) && (this.mHeaderLoader.size() > 0))
    {
      int i = 0;
      while (i < this.mHeaderLoader.size())
      {
        int j = this.mHeaderLoader.keyAt(i);
        aozt localaozt = (aozt)this.mHeaderLoader.get(j);
        if (localaozt != null) {
          localaozt.b();
        }
        i += 1;
      }
      this.mHeaderLoader.clear();
    }
    destroyRecentUserTask();
  }
  
  private void onFaceUpdate(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    int i = 0;
    if (i < this.grid_row_view0.getChildCount())
    {
      paramString2 = this.grid_row_view0.getChildAt(i).getTag();
      if (paramString2 == null) {}
      for (;;)
      {
        i += 1;
        break;
        if ((paramString2 instanceof ShareActionSheetBuilder.ActionSheetItemViewHolder))
        {
          paramString2 = (ShareActionSheetBuilder.ActionSheetItemViewHolder)paramString2;
          if (TextUtils.equals(paramString1, paramString2.sheetItem.uin))
          {
            paramString2.sheetItem.iconDrawable = new BitmapDrawable(paramBitmap);
            paramString2.vIcon.setBackgroundDrawable(paramString2.sheetItem.iconDrawable);
          }
        }
      }
    }
  }
  
  private void onRecentUserChanged(ArrayList<ResultRecord> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "onRecentUserChanged() called with: recentUsers = [" + paramArrayList + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    this.mActionSheetRecentUserItems.clear();
    int i = 0;
    if ((paramArrayList != null) && (i < paramArrayList.size()))
    {
      if (i < 15) {
        break label149;
      }
      paramArrayList = ShareActionSheetBuilder.ActionSheetItem.build(73);
      paramArrayList.iconNeedBg = false;
      localObject1 = BaseApplicationImpl.getApplication().getResources();
      if (!bbyp.a()) {
        break label134;
      }
    }
    label134:
    for (paramArrayList.iconDrawable = ((Resources)localObject1).getDrawable(2130849629);; paramArrayList.iconDrawable = ((Resources)localObject1).getDrawable(2130849628))
    {
      this.mActionSheetRecentUserItems.add(paramArrayList);
      createDialog();
      showInternal();
      return;
    }
    label149:
    Object localObject2 = (ResultRecord)paramArrayList.get(i);
    Object localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(72);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = ((ResultRecord)localObject2).name;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject1).uin = ((ResultRecord)localObject2).uin;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject1).uinType = ((ResultRecord)localObject2).type;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = false;
    Object localObject3 = new StringBuilder().append("isNewTroop=");
    int j;
    if (((ResultRecord)localObject2).isNewTroop)
    {
      j = 1;
      label227:
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = j;
      if ((6000 == ((ShareActionSheetBuilder.ActionSheetItem)localObject1).uinType) && (TextUtils.equals(AppConstants.DATALINE_PC_UIN, ((ShareActionSheetBuilder.ActionSheetItem)localObject1).uin)))
      {
        localObject2 = ShareActionSheetBuilder.ActionSheetItem.build(26);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).reportID = ((ShareActionSheetBuilder.ActionSheetItem)localObject2).reportID;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = false;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130844119;
        if (bbyp.a()) {
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130844118;
        }
        if (bjuk.a())
        {
          localObject2 = new Paint();
          ((Paint)localObject2).setAntiAlias(true);
          ((Paint)localObject2).setColor(ThemeUtil.NIGHTMODE_MASKCOLOR);
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = BitmapFactory.decodeResource(this.mOutAct.getResources(), ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon).copy(Bitmap.Config.ARGB_8888, true);
        localCanvas = new Canvas((Bitmap)localObject3);
        if (!bbyp.a()) {
          continue;
        }
        localCanvas.drawRoundRect(new RectF(0.0F, 0.0F, localCanvas.getWidth(), localCanvas.getHeight()), 10.0F, 10.0F, (Paint)localObject2);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconDrawable = new BitmapDrawable((Bitmap)localObject3);
      }
      catch (Throwable localThrowable)
      {
        Canvas localCanvas;
        QLog.e("ShareActionSheetV2", 1, "onRecentUserChanged: no night mode mask", localThrowable);
        continue;
      }
      this.mActionSheetRecentUserItems.add(localObject1);
      i += 1;
      break;
      j = 0;
      break label227;
      localCanvas.drawCircle(localCanvas.getWidth() / 2, localCanvas.getHeight() / 2, localCanvas.getWidth() / 2, (Paint)localObject2);
    }
  }
  
  private void registerActivityLifecycle()
  {
    ((Application)this.mOutAct.getApplicationContext()).registerActivityLifecycleCallbacks(this.mActivityLifecycleCallback);
  }
  
  private void reportClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    String str2 = ((Activity)this.mOutAct).getIntent().getStringExtra("big_brother_source_key");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = getGeneralUrlSourceKey();
    }
    if (paramActionSheetItem.action == 73) {
      bcef.b(null, "dc00898", "", "", "0X800AB3F", "0X800AB3F", 0, 0, getReportR2(), "", str1, "");
    }
    do
    {
      return;
      if (paramActionSheetItem.action == 72)
      {
        bcef.b(null, "dc00898", "", paramActionSheetItem.uin, "0X800AB3E", "0X800AB3E", 0, 0, getReportR2(), "", str1, paramActionSheetItem.reportID);
        return;
      }
      if (paramInt == 1)
      {
        bcef.b(null, "dc00898", "", "", "0X800AB40", "0X800AB40", 0, 0, getReportR2(), "", str1, paramActionSheetItem.reportID);
        return;
      }
    } while (paramInt != 2);
    bcef.b(null, "dc00898", "", "", "0X800AB41", "0X800AB41", 0, 0, getReportR2(), "", str1, paramActionSheetItem.reportID);
  }
  
  private void reportShowed()
  {
    Object localObject2 = ((Activity)this.mOutAct).getIntent().getStringExtra("big_brother_source_key");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = getGeneralUrlSourceKey();
    }
    localObject2 = new StringBuilder();
    List[] arrayOfList = getActionSheetItems();
    if (arrayOfList.length > 0)
    {
      int i = 0;
      while (i < arrayOfList[0].size())
      {
        ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)arrayOfList[0].get(i);
        if (i != 0) {
          ((StringBuilder)localObject2).append(';');
        }
        ((StringBuilder)localObject2).append(localActionSheetItem.reportID);
        i += 1;
      }
    }
    bcef.b(null, "dc00898", "", "", "0X800AB3D", "0X800AB3D", 0, 0, getReportR2(), "", (String)localObject1, ((StringBuilder)localObject2).toString());
  }
  
  private void setMoveIfNecessary(ElasticHorScrView paramElasticHorScrView, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      paramElasticHorScrView.setMove(true);
      return;
    }
    paramElasticHorScrView.setMove(false);
  }
  
  private void showInternal()
  {
    try
    {
      if (!isShowing())
      {
        if (this.mEnableNotTriggerVirtualNavigationBar) {
          zjv.b(getWindow());
        }
        this.mDialog.show();
        if (this.mEnableNotTriggerVirtualNavigationBar)
        {
          zjv.a(getWindow());
          zjv.c(getWindow());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheetV2", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  private void unRegisterActivityLifecycle()
  {
    ((Application)this.mOutAct.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.mActivityLifecycleCallback);
  }
  
  @TargetApi(9)
  protected View createViewFlipper()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "createViewFlipper() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    View localView = View.inflate(this.mOutAct, 2131558945, null);
    this.mAdViewManager.setAdContainer((RelativeLayout)localView.findViewById(2131362216));
    this.mActionSheetPanel = localView.findViewById(2131361977);
    this.mActionSheetLin = ((LinearLayout)localView.findViewById(2131361976));
    if (bjuk.a())
    {
      this.mActionSheetPanel.setBackgroundResource(2130849631);
      this.mActionSheetLin.setBackgroundResource(2130849631);
    }
    int j = 1;
    int k = 1;
    int m = 1;
    this.mTitleTv = ((TextView)localView.findViewById(2131361974));
    Object localObject3;
    Object localObject1;
    label255:
    Object localObject2;
    label279:
    label304:
    Object localObject4;
    int i;
    int n;
    int i1;
    if (this.showTitle)
    {
      this.mTitleTv.setVisibility(0);
      if (this.dialogTitle != null) {
        this.mTitleTv.setText(this.dialogTitle);
      }
      this.mScrollView0 = ((ElasticHorScrView)localView.findViewById(2131376871));
      this.mScrollView1 = ((ElasticHorScrView)localView.findViewById(2131376872));
      this.mScrollView2 = ((ElasticHorScrView)localView.findViewById(2131376873));
      this.mBottomBar = ((LinearLayout)localView.findViewById(2131361965));
      localObject3 = getActionSheetItems();
      if (localObject3.length <= 0) {
        break label497;
      }
      localObject1 = this.mActionSheetRecentUserItems;
      if (((List)localObject1).isEmpty()) {
        j = 0;
      }
      if (localObject3.length <= 0) {
        break label510;
      }
      localObject2 = localObject3[0];
      if (((List)localObject2).isEmpty()) {
        k = 0;
      }
      if (localObject3.length <= 1) {
        break label523;
      }
      localObject3 = localObject3[1];
      if (((List)localObject3).isEmpty()) {
        m = 0;
      }
      localObject4 = (TextView)LayoutInflater.from(this.mOutAct).inflate(2131558943, null);
      ((TextView)localObject4).setLayoutParams(new ViewGroup.LayoutParams(this.itemTextWidth, -2));
      i = getTextMeasuredHeight((List)localObject1, (TextView)localObject4);
      n = getTextMeasuredHeight((List)localObject2, (TextView)localObject4);
      i1 = getTextMeasuredHeight((List)localObject3, (TextView)localObject4);
      n = Math.max(Math.max(i, n), i1);
      i1 = this.mOutAct.getResources().getDimensionPixelOffset(2131296794);
      if (j == 0) {
        break label711;
      }
      this.grid_row_view0 = ((GridView)localView.findViewById(2131367714));
      if (Build.VERSION.SDK_INT >= 9) {
        this.mScrollView0.setOverScrollMode(2);
      }
      localObject4 = ((List)localObject1).iterator();
      i = 0;
      label457:
      if (!((Iterator)localObject4).hasNext()) {
        break label536;
      }
      if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject4).next()).visibility != 0) {
        break label1388;
      }
      i += 1;
    }
    label523:
    label536:
    label711:
    label1382:
    label1385:
    label1388:
    for (;;)
    {
      break label457;
      hideTitle();
      break;
      label497:
      localObject1 = new ArrayList(0);
      break label255;
      label510:
      localObject2 = new ArrayList(0);
      break label279;
      localObject3 = new ArrayList(0);
      break label304;
      int i2 = this.itemMargin + getIconWidth() + this.itemMargin;
      this.grid_row_view0.setColumnWidth(i2);
      this.grid_row_view0.setNumColumns(i);
      localObject4 = this.grid_row_view0.getLayoutParams();
      this.grid_row_view0.setPadding(this.scrollViewMargin, this.grid_row_view0.getPaddingTop(), this.scrollViewMargin, this.grid_row_view0.getPaddingBottom());
      ((ViewGroup.LayoutParams)localObject4).width = (i2 * i + this.scrollViewMargin + this.scrollViewMargin);
      this.mGridView0Length = ((ViewGroup.LayoutParams)localObject4).width;
      ((ViewGroup.LayoutParams)localObject4).height = (this.itemImageSize + this.itemTextMargin + n + i1);
      this.grid_row_view0.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      this.grid_row_view0.setAdapter(new ShareActionSheetV2.ActionSheetItemAdapter(this.mOutAct, (List)localObject1, this));
      this.grid_row_view0.setSelector(new ColorDrawable(0));
      this.grid_row_view0.setOnItemClickListener(this.mClickListener);
      if (k != 0)
      {
        this.grid_row_view1 = ((GridView)localView.findViewById(2131367715));
        if (Build.VERSION.SDK_INT >= 9) {
          this.mScrollView1.setOverScrollMode(2);
        }
        localObject1 = ((List)localObject2).iterator();
        i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject1).next()).visibility != 0) {
            break label1385;
          }
          i += 1;
        }
      }
      for (;;)
      {
        break;
        i2 = this.itemMargin + getIconWidth() + this.itemMargin;
        this.grid_row_view1.setColumnWidth(i2);
        this.grid_row_view1.setNumColumns(i);
        localObject1 = this.grid_row_view1.getLayoutParams();
        this.grid_row_view1.setPadding(this.scrollViewMargin, this.grid_row_view1.getPaddingTop(), this.scrollViewMargin, this.grid_row_view1.getPaddingBottom());
        ((ViewGroup.LayoutParams)localObject1).width = (i2 * i + this.scrollViewMargin + this.scrollViewMargin);
        this.mGridView1Length = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject1).height = (this.itemImageSize + this.itemTextMargin + n + i1);
        this.grid_row_view1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.grid_row_view1.setAdapter(new ShareActionSheetV2.ActionSheetItemAdapter(this.mOutAct, (List)localObject2, this));
        this.grid_row_view1.setSelector(new ColorDrawable(0));
        this.grid_row_view1.setOnItemClickListener(this.mClickListener);
        if (m != 0)
        {
          this.grid_row_view2 = ((GridView)localView.findViewById(2131367716));
          if (Build.VERSION.SDK_INT >= 9) {
            this.mScrollView2.setOverScrollMode(2);
          }
          this.grid_row_view2.setSmoothScrollbarEnabled(false);
          localObject1 = ((List)localObject3).iterator();
          i = 0;
          if (((Iterator)localObject1).hasNext())
          {
            if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject1).next()).visibility != 0) {
              break label1382;
            }
            i += 1;
          }
        }
        for (;;)
        {
          break;
          i2 = this.itemMargin + getIconWidth() + this.itemMargin;
          this.grid_row_view2.setColumnWidth(i2);
          this.grid_row_view2.setNumColumns(i);
          localObject1 = this.grid_row_view2.getLayoutParams();
          this.grid_row_view2.setPadding(this.scrollViewMargin, this.grid_row_view2.getPaddingTop(), this.scrollViewMargin, this.grid_row_view2.getPaddingBottom());
          ((ViewGroup.LayoutParams)localObject1).width = (i2 * i + this.scrollViewMargin + this.scrollViewMargin);
          this.mGridView2Length = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject1).height = (this.itemImageSize + this.itemTextMargin + n + i1);
          this.grid_row_view2.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.grid_row_view2.setNumColumns(i);
          this.grid_row_view2.setAdapter(new ShareActionSheetV2.ActionSheetItemAdapter(this.mOutAct, (List)localObject3, this));
          this.grid_row_view2.setSelector(new ColorDrawable(0));
          this.grid_row_view2.setOnItemClickListener(this.mClickListener);
          this.cancel = ((ImageView)localView.findViewById(2131361966));
          this.cancel.setOnClickListener(new ShareActionSheetV2.8(this));
          if ((j == 0) || (this.mRowFriendsVisibility == 8)) {
            this.mScrollView0.setVisibility(8);
          }
          if ((k == 0) || (this.mRowPathsVisibility == 8)) {
            this.mScrollView1.setVisibility(8);
          }
          if ((m == 0) || (this.mRowOperationsVisibility == 8)) {
            this.mScrollView2.setVisibility(8);
          }
          localView.post(new ShareActionSheetV2.9(this));
          if (this.mBottomBarInterface != null)
          {
            localObject1 = this.mBottomBarInterface.createBottomBar();
            if (localObject1 != null) {
              this.mBottomBar.addView((View)localObject1);
            }
          }
          return localView;
        }
      }
    }
  }
  
  public void dismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "dismiss() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    dismissInternal(false);
  }
  
  public void dismissImmediately()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "dismissImmediately() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    dismissInternal(true);
  }
  
  public View findViewById(int paramInt)
  {
    if (this.mDialog == null) {}
    Window localWindow;
    do
    {
      return null;
      localWindow = this.mDialog.getWindow();
    } while (localWindow == null);
    return localWindow.findViewById(paramInt);
  }
  
  public bjnw getActionSheet()
  {
    return this.mDialog;
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] getActionSheetItems()
  {
    if (this.mActionSheetItems != null) {
      return this.mActionSheetItems;
    }
    return (List[])new ArrayList[0];
  }
  
  public int getActionSheetPanelViewHeight()
  {
    if (this.mActionSheetPanel != null) {
      return this.mActionSheetPanel.getHeight();
    }
    return 0;
  }
  
  public int getIconWidth()
  {
    return this.itemImageSize;
  }
  
  protected String getLongestLabel(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    Object localObject = "";
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((ShareActionSheetBuilder.ActionSheetItem)paramList.get(i)).label;
      if (str.length() <= ((String)localObject).length()) {
        break label55;
      }
      localObject = str;
    }
    label55:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  public String getOpenSource()
  {
    return this.openSource;
  }
  
  public Window getWindow()
  {
    if (this.mDialog == null) {
      return null;
    }
    return this.mDialog.getWindow();
  }
  
  public void hideTitle()
  {
    this.showTitle = false;
    if ((this.mTitleTv != null) && (this.mTitleTv.getVisibility() != 8)) {
      this.mTitleTv.setVisibility(8);
    }
  }
  
  public boolean isShowing()
  {
    return (this.mDialog != null) && (this.mDialog.isShowing());
  }
  
  public void onConfigurationChanged()
  {
    if ((this.mOutAct == null) || (!isShowing())) {
      return;
    }
    int i = this.mOutAct.getResources().getDisplayMetrics().widthPixels - this.scrollViewMargin;
    setMoveIfNecessary(this.mScrollView0, i, this.mGridView0Length);
    setMoveIfNecessary(this.mScrollView1, i, this.mGridView1Length);
    setMoveIfNecessary(this.mScrollView2, i, this.mGridView2Length);
  }
  
  public void refresh()
  {
    if (this.mDialog == null) {}
    while (!this.mDialog.isShowing()) {
      return;
    }
    this.mShowView = createViewFlipper();
    this.mDialog.a(this.mShowView, null);
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem> paramList1, List<ShareActionSheetBuilder.ActionSheetItem> paramList2)
  {
    setActionSheetItems(new ArrayList[] { (ArrayList)paramList1, (ArrayList)paramList2 });
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfList)
  {
    this.mActionSheetItems = paramArrayOfList;
    this.mIsDataChanged = true;
  }
  
  public void setActionSheetTitle(CharSequence paramCharSequence)
  {
    this.dialogTitle = paramCharSequence;
    if (this.mTitleTv != null) {
      this.mTitleTv.setText(this.dialogTitle);
    }
  }
  
  public void setAdvBgColor(int paramInt)
  {
    this.mAdViewManager.setBgColor(paramInt);
  }
  
  public void setAdvView(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.mAdViewManager.setAdView(paramView, paramLayoutParams);
  }
  
  public void setBottomBarInterface(ShareActionSheet.IShareActionSheetV2BottomBar paramIShareActionSheetV2BottomBar)
  {
    this.mBottomBarInterface = paramIShareActionSheetV2BottomBar;
  }
  
  public void setCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "setCancelListener() called with: listener = [" + paramOnCancelListener + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    this.mClientCancelListener = paramOnCancelListener;
  }
  
  public void setEnableNotTriggerVirtualNavigationBar(boolean paramBoolean)
  {
    this.mEnableNotTriggerVirtualNavigationBar = paramBoolean;
  }
  
  public void setExtras(Bundle paramBundle) {}
  
  public void setIconMarginLeftRight(int paramInt)
  {
    this.itemMargin = paramInt;
  }
  
  public void setIntentForStartForwardRecentActivity(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "setIntentForStartForwardRecentActivity() called with: intent = [" + paramIntent + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    this.mIntentForStartForwardRecentActivity = paramIntent;
  }
  
  public void setItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener) {}
  
  public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener paramOnItemClickListener)
  {
    this.mItemClickListener = paramOnItemClickListener;
    this.mIsDataChanged = true;
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "setOnDismissListener() called with: dismissListener = [" + paramOnDismissListener + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    this.mClientDismissListener = paramOnDismissListener;
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    this.mClientOnShowListener = paramOnShowListener;
  }
  
  public void setOpenSource(String paramString)
  {
    this.openSource = paramString;
  }
  
  public void setRowMarginLeftRight(int paramInt)
  {
    this.scrollViewMargin = paramInt;
  }
  
  public void setRowVisibility(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mRowFriendsVisibility = paramInt1;
    this.mRowPathsVisibility = paramInt2;
    this.mRowOperationsVisibility = paramInt3;
  }
  
  public void show()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "show() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    if ((this.mIsPendingShow) || (isShowing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShareActionSheetV2", 2, "show() isShowing #this = " + Integer.toHexString(System.identityHashCode(this)));
      }
      return;
    }
    this.mIsPendingShow = true;
    if (needLoadRecentUser())
    {
      loadRecentUsersAsync();
      return;
    }
    createDialog();
    showInternal();
  }
  
  public void updateUI() {}
  
  public void updateUIIfShowing() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2
 * JD-Core Version:    0.7.0.1
 */