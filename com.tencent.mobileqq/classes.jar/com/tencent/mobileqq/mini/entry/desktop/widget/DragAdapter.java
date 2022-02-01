package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.MicroAppViewHolder;
import com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.ModuleGuideViewHolder;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppGroupInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopEmptyGuideInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class DragAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements DragRecyclerView.OnItemChangeListener
{
  private static final long DRAG_INSERT_DURA = 200L;
  private static final String TAG = "DragAdapter";
  int currDragMoveLeft;
  int currDragMoveTop;
  int lastDragLeft;
  int lastDragMoveLeft;
  int lastDragMoveTop;
  int lastDragTop;
  private Context mContext;
  protected List<DesktopItemInfo> mData = new ArrayList();
  private boolean mDeletePrepared = false;
  protected int mDeleteTarget = -1;
  protected int mDragIndex = -1;
  protected ImageView mDragMirrorImage;
  protected View mDragMirrorLayout;
  protected ImageView mDragMirrorMarkImage;
  private RecyclerView.ViewHolder mDragViewHolder;
  private int mIntertFrom = -1;
  private int mIntertTarget = -1;
  private Handler mMainHandler = new Handler(Looper.getMainLooper());
  private DragAdapter.MoveItemRunnable mMoveItemRunnable = new DragAdapter.MoveItemRunnable(this, null);
  private DragAdapter.MoveRunnable mMoveRunnable = new DragAdapter.MoveRunnable(this);
  protected DragRecyclerView mParentRecyclerView;
  protected DragRecyclerView mRecyclerView;
  private Vibrator mVibrator;
  protected ScaleAnimation mirrorRevertAnimation = new ScaleAnimation(1.2F, 1.0F, 1.2F, 1.0F, 1, 0.5F, 1, 0.5F);
  protected ScaleAnimation mirrorZoomAnimation = new ScaleAnimation(1.0F, 1.2F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
  protected int moveStartX;
  protected int moveStartY;
  protected boolean outsideDragCancel = false;
  protected DesktopAppInfo outsideDragFromInfo;
  protected int startDragX;
  protected int startDragY;
  protected int startDragYDiff;
  
  public DragAdapter(Context paramContext, DragRecyclerView paramDragRecyclerView)
  {
    this.mContext = paramContext;
    this.mRecyclerView = paramDragRecyclerView;
  }
  
  private void doOnDragFinish(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder = this.mDragViewHolder;
    if (paramViewHolder != null) {
      paramInt = paramViewHolder.itemView.getLeft();
    } else {
      paramInt = 0;
    }
    paramViewHolder = this.mDragViewHolder;
    int i;
    if (paramViewHolder != null) {
      i = paramViewHolder.itemView.getTop();
    } else {
      i = 0;
    }
    paramViewHolder = this.mDragMirrorLayout;
    if (paramViewHolder != null)
    {
      paramInt = paramViewHolder.getLeft();
      i = this.mDragMirrorLayout.getTop();
    }
    boolean bool3 = isSameModule(this.mDragIndex, this.mIntertTarget);
    int j;
    if ((!this.mDeletePrepared) && ((bool3) || (this.mIntertTarget < 0))) {
      j = 1;
    } else {
      j = 0;
    }
    boolean bool2 = isDragCancel();
    boolean bool1 = bool2;
    if (getTargetDragModuleType(this.mIntertTarget) == 3)
    {
      paramViewHolder = this.outsideDragFromInfo;
      if (paramViewHolder == null) {
        paramViewHolder = (DesktopAppInfo)this.mData.get(this.mDragIndex);
      }
      bool1 = bool2;
      if (paramViewHolder.mMiniAppInfo.isWxMiniApp()) {
        bool1 = true;
      }
    }
    if (bool1)
    {
      paramViewHolder = new StringBuilder();
      paramViewHolder.append("Desktop-Drag onDragFinish isDragCancel：");
      paramViewHolder.append(bool1);
      QLog.i("DragAdapter", 1, paramViewHolder.toString());
      int k = 0;
      while (k < this.mData.size())
      {
        if (((DesktopItemInfo)this.mData.get(k)).isTemp)
        {
          if (bool3)
          {
            ((DesktopItemInfo)this.mData.get(k)).setIsTemp(false);
            notifyItemChanged(k);
            this.mIntertTarget = -1;
            break;
          }
          this.mData.remove(k);
          notifyItemRemoved(k);
          this.mIntertTarget = -1;
          break;
        }
        k += 1;
      }
    }
    paramViewHolder = this.mDragViewHolder;
    Object localObject1 = this.mDragMirrorLayout;
    Object localObject3;
    if (localObject1 != null)
    {
      ((View)localObject1).clearAnimation();
      if (j == 0)
      {
        this.mDragMirrorLayout.setVisibility(4);
        localObject1 = this.mDragViewHolder;
        if (localObject1 != null)
        {
          ((RecyclerView.ViewHolder)localObject1).itemView.setVisibility(0);
          this.mDragViewHolder.itemView.setAlpha(0.0F);
          this.mMainHandler.postDelayed(new DragAdapter.3(this, paramViewHolder), 350L);
        }
      }
      else if (!bool3)
      {
        localObject1 = new AnimationSet(true);
        ((AnimationSet)localObject1).addAnimation(this.mirrorRevertAnimation);
        localObject3 = new TranslateAnimation(0.0F, this.startDragX - paramInt, 0.0F, this.startDragY - i);
        ((TranslateAnimation)localObject3).setDuration(200L);
        ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
        ((AnimationSet)localObject1).setAnimationListener(new DragAdapter.4(this, paramViewHolder));
        this.mDragMirrorLayout.setAnimation((Animation)localObject1);
        ((AnimationSet)localObject1).start();
      }
      else
      {
        paramViewHolder = this.mDragViewHolder;
        if (paramViewHolder != null) {
          paramViewHolder.itemView.setVisibility(0);
        }
        this.mDragMirrorLayout.setVisibility(4);
      }
    }
    else if (paramViewHolder != null)
    {
      paramViewHolder.itemView.setVisibility(0);
    }
    paramInt = this.mIntertTarget;
    if ((paramInt >= 0) && (!this.mDeletePrepared))
    {
      Object localObject2;
      if (((DesktopItemInfo)this.mData.get(paramInt) instanceof DesktopEmptyGuideInfo))
      {
        paramViewHolder = this.outsideDragFromInfo;
        if (paramViewHolder == null) {
          paramViewHolder = (DesktopAppInfo)this.mData.get(this.mDragIndex);
        }
        localObject1 = new DesktopAppGroupInfo(3);
        localObject3 = new ArrayList();
        ((List)localObject3).add(new DesktopAppInfo(3, paramViewHolder.mMiniAppInfo));
        ((DesktopAppGroupInfo)localObject1).setData((List)localObject3);
        this.mData.set(this.mIntertTarget, localObject1);
        notifyItemChanged(this.mIntertTarget);
        try
        {
          ((DesktopDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER)).onItemChanged(this.mIntertTarget, new DesktopAppInfo(3, paramViewHolder.mMiniAppInfo));
        }
        catch (Throwable localThrowable)
        {
          QLog.e("DragAdapter", 1, localThrowable, new Object[0]);
        }
        MiniAppCmdUtil.getInstance().setUserAppTop(paramViewHolder.mMiniAppInfo.appId, 1, paramViewHolder.mMiniAppInfo.verType, -1, 0, null, new DragAdapter.5(this));
        localObject2 = new MiniAppConfig(paramViewHolder.mMiniAppInfo);
        if (paramViewHolder.getModuleType() == 1)
        {
          ((MiniAppConfig)localObject2).launchParam.scene = 3001;
          MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject2, "desktop", "add", "add_lately", null);
          return;
        }
        if (paramViewHolder.getModuleType() == 2)
        {
          ((MiniAppConfig)localObject2).launchParam.scene = 3002;
          MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject2, "desktop", "add", "add_recommend", null);
        }
      }
      else
      {
        if (getItemCount() > MiniAppConfProcessor.f())
        {
          paramInt = this.mIntertTarget;
          this.mMainHandler.post(new DragAdapter.6(this, paramInt));
          return;
        }
        localObject2 = (DesktopAppInfo)this.mData.get(this.mIntertTarget);
        if (((DesktopAppInfo)localObject2).isTemp)
        {
          ((DesktopAppInfo)localObject2).setIsTemp(false);
          try
          {
            notifyItemChanged(this.mIntertTarget);
          }
          catch (Throwable paramViewHolder)
          {
            QLog.e("DragAdapter", 1, "onDragFinish exception!", paramViewHolder);
            paramInt = this.mIntertTarget;
            this.mMainHandler.postDelayed(new DragAdapter.7(this, paramInt), 200L);
          }
        }
        j = ((DesktopDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER)).getTopModuleInfoIndex() + 1;
        paramInt = this.mDragIndex;
        i = this.mIntertTarget;
        paramViewHolder = this.mParentRecyclerView;
        if ((paramViewHolder != null) && (paramViewHolder.getAdapter() != null) && (this.mDragIndex < 0))
        {
          i = this.mIntertTarget;
          paramInt = -1;
        }
        MiniAppCmdUtil.getInstance().setUserAppTop(((DesktopAppInfo)localObject2).mMiniAppInfo.appId, 1, ((DesktopAppInfo)localObject2).mMiniAppInfo.verType, paramInt, i, null, new DragAdapter.8(this));
        paramViewHolder = this.outsideDragFromInfo;
        if (paramViewHolder == null) {
          paramViewHolder = (DesktopAppInfo)this.mData.get(this.mDragIndex);
        }
        if (paramViewHolder != null)
        {
          localObject3 = new MiniAppConfig(paramViewHolder.mMiniAppInfo);
          if (paramViewHolder.getModuleType() == 1)
          {
            ((MiniAppConfig)localObject3).launchParam.scene = 3001;
            MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject3, "desktop", "add", "add_lately", null);
          }
          else if (paramViewHolder.getModuleType() == 2)
          {
            ((MiniAppConfig)localObject3).launchParam.scene = 3002;
            MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject3, "desktop", "add", "add_recommend", null);
          }
        }
        if (!this.mDeletePrepared)
        {
          paramViewHolder = this.mParentRecyclerView;
          paramInt = j;
          if (paramViewHolder != null)
          {
            paramInt = j;
            if (paramViewHolder.getAdapter() != null) {
              paramInt = 0;
            }
          }
          while (paramInt < getItemCount())
          {
            if ((this.mData.get(paramInt) instanceof DesktopAppModuleInfo)) {
              return;
            }
            if (((this.mData.get(paramInt) instanceof DesktopAppInfo)) && (paramInt != this.mIntertTarget))
            {
              paramViewHolder = (DesktopAppInfo)this.mData.get(paramInt);
              if (((DesktopAppInfo)localObject2).mMiniAppInfo.equals(paramViewHolder.mMiniAppInfo))
              {
                this.mData.remove(paramInt);
                notifyItemRemoved(paramInt);
                notifyItemRangeChanged(paramInt, getItemCount());
                return;
              }
            }
            paramInt += 1;
          }
        }
      }
    }
  }
  
  private void doVibrate()
  {
    try
    {
      if (this.mVibrator == null) {
        this.mVibrator = ((Vibrator)this.mContext.getSystemService("vibrator"));
      }
      if (this.mVibrator != null)
      {
        this.mVibrator.vibrate(50L);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DragAdapter", 1, "exception when doVibrate.", localThrowable);
    }
  }
  
  private int getTargetDragModuleType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getItemCount())) {
      return ((DesktopItemInfo)this.mData.get(paramInt)).mModuleType;
    }
    return -1;
  }
  
  private boolean isSameModule(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 >= 0)
    {
      bool1 = bool2;
      if (paramInt1 < getItemCount())
      {
        bool1 = bool2;
        if (paramInt2 >= 0)
        {
          if (paramInt2 >= getItemCount()) {
            return false;
          }
          DesktopItemInfo localDesktopItemInfo1 = (DesktopItemInfo)this.mData.get(paramInt1);
          DesktopItemInfo localDesktopItemInfo2 = (DesktopItemInfo)this.mData.get(paramInt2);
          bool1 = bool2;
          if (localDesktopItemInfo1.mModuleType == localDesktopItemInfo2.mModuleType) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void setDragMirrorPosition(int paramInt1, int paramInt2)
  {
    Object localObject = this.mDragMirrorLayout;
    if ((localObject != null) && (this.mDragMirrorImage != null))
    {
      localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).setMargins(paramInt1, paramInt2, 0, 0);
      this.mDragMirrorLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private boolean shouldShowMirrorMask()
  {
    Object localObject1 = this.mParentRecyclerView;
    if (localObject1 == null) {
      localObject1 = this.mRecyclerView;
    }
    localObject1 = ((DragRecyclerView)localObject1).getChildRecycleView().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (DragRecyclerView)((Iterator)localObject1).next();
      if ((((DragRecyclerView)localObject2).getAdapter() instanceof DragAdapter))
      {
        localObject2 = (DragAdapter)((DragRecyclerView)localObject2).getAdapter();
        if ((((DragAdapter)localObject2).mIntertTarget > 0) || (((DragAdapter)localObject2).mDeletePrepared)) {
          return true;
        }
      }
    }
    return false;
  }
  
  protected void doDragMove(int paramInt1, int paramInt2)
  {
    Object localObject2 = findChildViewAt(paramInt1, paramInt2);
    DesktopItemInfo localDesktopItemInfo1 = null;
    Object localObject1;
    if (localObject2 != null) {
      localObject1 = this.mRecyclerView.getChildViewHolder((View)localObject2);
    } else {
      localObject1 = null;
    }
    int k;
    int i;
    int j;
    if (localObject1 != null)
    {
      k = ((RecyclerView.ViewHolder)localObject1).getAdapterPosition();
      DesktopItemInfo localDesktopItemInfo2 = (DesktopItemInfo)this.mData.get(k);
      if ((localDesktopItemInfo2.dropEnable) && (!localDesktopItemInfo2.isTemp)) {
        i = k;
      } else {
        i = -1;
      }
      double d1 = paramInt1;
      double d2 = ((View)localObject2).getLeft();
      double d3 = ((View)localObject2).getWidth();
      Double.isNaN(d3);
      Double.isNaN(d2);
      if (d1 > d2 + d3 * 0.66D)
      {
        j = k + 1;
        if (j < this.mData.size())
        {
          localObject2 = (DesktopItemInfo)this.mData.get(j);
          if ((((DesktopItemInfo)localObject2).dropEnable) && (!((DesktopItemInfo)localObject2).isTemp)) {
            break label202;
          }
        }
        else
        {
          i = 1;
          j = -1;
          break label217;
        }
      }
      j = i;
      label202:
      i = 0;
    }
    else
    {
      i = 0;
      j = -1;
      k = -1;
    }
    label217:
    if ((j >= 0) && (j != this.mDragIndex))
    {
      k = this.mIntertTarget;
      int m;
      if (k < 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Desktop-Drag onDragInsert target：");
        ((StringBuilder)localObject1).append(j);
        QLog.i("DragAdapter", 1, ((StringBuilder)localObject1).toString());
        localObject1 = this.outsideDragFromInfo;
        if (localObject1 == null)
        {
          k = this.mDragIndex;
          localObject1 = localDesktopItemInfo1;
          if (k >= 0) {
            localObject1 = (DesktopAppInfo)this.mData.get(k);
          }
        }
        k = this.mDragIndex;
        boolean bool;
        if (k >= 0) {
          bool = isSameModule(k, j);
        } else {
          bool = false;
        }
        if (localObject1 != null) {
          if (bool)
          {
            k = this.mDragIndex;
            m = k;
            if (k < j) {
              while (k < j)
              {
                localObject1 = this.mData;
                m = k + 1;
                Collections.swap((List)localObject1, k, m);
                k = m;
              }
            }
            while (m > j)
            {
              Collections.swap(this.mData, m, m - 1);
              m -= 1;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Desktop-Drag OP_SWAP fromOld:");
            ((StringBuilder)localObject1).append(this.mIntertTarget);
            ((StringBuilder)localObject1).append(" target:");
            ((StringBuilder)localObject1).append(j);
            QLog.i("DragAdapter", 1, ((StringBuilder)localObject1).toString());
            ((DesktopItemInfo)this.mData.get(j)).setIsTemp(true);
            notifyItemMoved(this.mDragIndex, j);
            this.mDragIndex = j;
            this.mIntertTarget = j;
          }
          else
          {
            this.mIntertTarget = j;
            if ((getTargetDragModuleType(this.mIntertTarget) != 3) || (((DesktopAppInfo)localObject1).mMiniAppInfo == null) || (!((DesktopAppInfo)localObject1).mMiniAppInfo.isWxMiniApp()))
            {
              localObject1 = new DesktopAppInfo(((DesktopAppInfo)this.mData.get(j)).mModuleType, ((DesktopAppInfo)localObject1).mMiniAppInfo);
              ((DesktopItemInfo)localObject1).setIsTemp(true);
              this.mData.add(j, localObject1);
              notifyItemInserted(j);
            }
          }
        }
      }
      else if (j != k)
      {
        m = k;
        if (k < j) {
          while (k < j)
          {
            localObject1 = this.mData;
            m = k + 1;
            Collections.swap((List)localObject1, k, m);
            k = m;
          }
        }
        while (m > j)
        {
          Collections.swap(this.mData, m, m - 1);
          m -= 1;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Desktop-Drag OP_SWAP fromOld:");
        ((StringBuilder)localObject1).append(this.mIntertTarget);
        ((StringBuilder)localObject1).append(" target:");
        ((StringBuilder)localObject1).append(j);
        QLog.i("DragAdapter", 1, ((StringBuilder)localObject1).toString());
        notifyItemMoved(this.mIntertTarget, j);
        this.mIntertTarget = j;
      }
    }
    else if ((localObject1 instanceof MiniAppDesktopAdapter.ModuleGuideViewHolder))
    {
      this.mIntertTarget = k;
    }
    else
    {
      j = this.mIntertTarget;
      if ((j > 0) && (getItemViewType(j) == 4)) {
        this.mIntertTarget = -1;
      }
    }
    if (this.mDragMirrorMarkImage != null)
    {
      if ((this.mIntertTarget <= 0) && (i == 0)) {
        j = 0;
      } else {
        j = 1;
      }
      if ((j == 0) && (!shouldShowMirrorMask())) {
        this.mDragMirrorMarkImage.setVisibility(4);
      } else {
        this.mDragMirrorMarkImage.setVisibility(0);
      }
    }
    if ((Math.abs(paramInt1 - this.lastDragLeft) > ViewUtils.dpToPx(5.0F)) || (Math.abs(paramInt2 - this.lastDragTop) > ViewUtils.dpToPx(5.0F)))
    {
      this.lastDragLeft = paramInt1;
      this.lastDragTop = paramInt2;
      try
      {
        if (this.mIntertTarget < 0)
        {
          localObject1 = this.mRecyclerView.findViewHolderForAdapterPosition(getItemCount() - 1);
          if ((i != 0) || ((localObject1 != null) && (paramInt1 - ((RecyclerView.ViewHolder)localObject1).itemView.getLeft() >= ViewUtils.dpToPx(20.0F)) && (paramInt2 - ((RecyclerView.ViewHolder)localObject1).itemView.getTop() >= ViewUtils.dpToPx(5.0F))))
          {
            localDesktopItemInfo1 = (DesktopItemInfo)this.mData.get(getItemCount() - 1);
            if ((localDesktopItemInfo1.dropEnable) && (!localDesktopItemInfo1.isTemp) && (!isSameModule(this.mDragIndex, getItemCount() - 1)))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Desktop-Drag into tail blank area from:");
              ((StringBuilder)localObject1).append(this.mDragIndex);
              QLog.i("DragAdapter", 1, ((StringBuilder)localObject1).toString());
              if (this.outsideDragFromInfo != null) {
                localObject1 = this.outsideDragFromInfo;
              } else {
                localObject1 = (DesktopAppInfo)this.mData.get(this.mDragIndex);
              }
              if ((localDesktopItemInfo1.mModuleType != 3) || (!((DesktopAppInfo)localObject1).mMiniAppInfo.isWxMiniApp()))
              {
                localObject1 = new DesktopAppInfo(localDesktopItemInfo1.mModuleType, ((DesktopAppInfo)localObject1).mMiniAppInfo);
                ((DesktopItemInfo)localObject1).setIsTemp(true);
                this.mData.add(localObject1);
                this.mIntertTarget = (this.mData.size() - 1);
                notifyItemInserted(this.mData.size() - 1);
                return;
              }
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("DragAdapter", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  public View findChildViewAt(float paramFloat1, float paramFloat2)
  {
    int i = (int)paramFloat1;
    int j = (int)paramFloat2;
    int k = ViewUtils.dip2px(45.0F);
    return this.mRecyclerView.findChildViewUnder(i, j - k);
  }
  
  public List<DesktopItemInfo> getData()
  {
    return new ArrayList(this.mData);
  }
  
  protected int getDragParentLeft(RecyclerView.ViewHolder paramViewHolder)
  {
    return ((View)paramViewHolder.itemView.getParent()).getLeft();
  }
  
  protected int getDragParentTop(RecyclerView.ViewHolder paramViewHolder)
  {
    return ((View)paramViewHolder.itemView.getParent()).getTop();
  }
  
  protected int getDragPosition()
  {
    RecyclerView.ViewHolder localViewHolder = this.mDragViewHolder;
    if (localViewHolder != null) {
      localViewHolder.getAdapterPosition();
    }
    return -1;
  }
  
  protected boolean isDragCancel()
  {
    Object localObject = this.mDragViewHolder;
    boolean bool2 = false;
    int i;
    if (localObject != null) {
      i = ((RecyclerView.ViewHolder)localObject).itemView.getLeft();
    } else {
      i = 0;
    }
    localObject = this.mDragViewHolder;
    int j;
    if (localObject != null) {
      j = ((RecyclerView.ViewHolder)localObject).itemView.getTop();
    } else {
      j = 0;
    }
    localObject = this.mDragMirrorLayout;
    if (localObject != null)
    {
      i = ((View)localObject).getLeft();
      j = this.mDragMirrorLayout.getTop();
    }
    boolean bool1;
    if (!this.outsideDragCancel)
    {
      bool1 = bool2;
      if (Math.abs(this.startDragX - i) < ViewUtils.dpToPx(15.0F))
      {
        bool1 = bool2;
        if (Math.abs(this.startDragY - j) >= ViewUtils.dpToPx(15.0F)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean isDropable()
  {
    List localList = this.mData;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localList != null)
    {
      bool1 = bool2;
      if (localList.size() > 0)
      {
        bool1 = bool2;
        if (((DesktopItemInfo)this.mData.get(0)).dropEnable) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isItemDeleteable(int paramInt)
  {
    return false;
  }
  
  public boolean isItemDragable(int paramInt)
  {
    return false;
  }
  
  public boolean isItemDropable(int paramInt)
  {
    return false;
  }
  
  public boolean isMoveToDeleteArea(int paramInt1, int paramInt2)
  {
    return paramInt2 >= this.mRecyclerView.getHeight() - ViewUtils.dpToPx(60.0F);
  }
  
  /* Error */
  public void onDragFinish(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: new 195	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   12: astore_3
    //   13: aload_3
    //   14: ldc_w 619
    //   17: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_3
    //   22: iload_2
    //   23: invokevirtual 529	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_3
    //   28: ldc_w 539
    //   31: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_3
    //   36: aload_0
    //   37: getfield 84	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:mIntertTarget	I
    //   40: invokevirtual 529	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: ldc 15
    //   46: iconst_1
    //   47: aload_3
    //   48: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 215	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: aload_0
    //   55: aload_1
    //   56: iload_2
    //   57: invokespecial 621	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:doOnDragFinish	(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    //   60: aload_0
    //   61: getfield 126	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:mRecyclerView	Lcom/tencent/mobileqq/mini/entry/desktop/widget/DragRecyclerView;
    //   64: invokevirtual 624	com/tencent/mobileqq/mini/entry/desktop/widget/DragRecyclerView:stopAutoScroll	()V
    //   67: aload_0
    //   68: iconst_m1
    //   69: putfield 80	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:mDragIndex	I
    //   72: aload_0
    //   73: aconst_null
    //   74: putfield 146	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:mDragViewHolder	Landroid/support/v7/widget/RecyclerView$ViewHolder;
    //   77: aload_0
    //   78: iconst_m1
    //   79: putfield 82	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:mIntertFrom	I
    //   82: aload_0
    //   83: iconst_m1
    //   84: putfield 84	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:mIntertTarget	I
    //   87: aload_0
    //   88: getfield 108	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:mMoveItemRunnable	Lcom/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter$MoveItemRunnable;
    //   91: invokevirtual 627	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter$MoveItemRunnable:reset	()V
    //   94: aload_0
    //   95: getfield 115	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:mMoveRunnable	Lcom/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter$MoveRunnable;
    //   98: invokevirtual 628	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter$MoveRunnable:reset	()V
    //   101: aload_0
    //   102: iconst_0
    //   103: putfield 86	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:mDeletePrepared	Z
    //   106: aload_0
    //   107: iconst_m1
    //   108: putfield 630	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:moveStartX	I
    //   111: aload_0
    //   112: iconst_m1
    //   113: putfield 632	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:moveStartY	I
    //   116: aload_0
    //   117: aconst_null
    //   118: putfield 176	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:outsideDragFromInfo	Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;
    //   121: aload_0
    //   122: iconst_0
    //   123: putfield 122	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:outsideDragCancel	Z
    //   126: aload_0
    //   127: iconst_m1
    //   128: putfield 270	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:startDragX	I
    //   131: aload_0
    //   132: iconst_m1
    //   133: putfield 272	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:startDragY	I
    //   136: aload_0
    //   137: iconst_0
    //   138: putfield 634	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:startDragYDiff	I
    //   141: aload_0
    //   142: iconst_m1
    //   143: putfield 88	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:mDeleteTarget	I
    //   146: return
    //   147: astore_1
    //   148: goto +17 -> 165
    //   151: astore_1
    //   152: ldc 15
    //   154: iconst_1
    //   155: ldc_w 636
    //   158: aload_1
    //   159: invokestatic 415	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   162: goto -95 -> 67
    //   165: aload_0
    //   166: iconst_m1
    //   167: putfield 80	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:mDragIndex	I
    //   170: aload_0
    //   171: aconst_null
    //   172: putfield 146	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:mDragViewHolder	Landroid/support/v7/widget/RecyclerView$ViewHolder;
    //   175: aload_0
    //   176: iconst_m1
    //   177: putfield 82	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:mIntertFrom	I
    //   180: aload_0
    //   181: iconst_m1
    //   182: putfield 84	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:mIntertTarget	I
    //   185: aload_0
    //   186: getfield 108	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:mMoveItemRunnable	Lcom/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter$MoveItemRunnable;
    //   189: invokevirtual 627	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter$MoveItemRunnable:reset	()V
    //   192: aload_0
    //   193: getfield 115	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:mMoveRunnable	Lcom/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter$MoveRunnable;
    //   196: invokevirtual 628	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter$MoveRunnable:reset	()V
    //   199: aload_0
    //   200: iconst_0
    //   201: putfield 86	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:mDeletePrepared	Z
    //   204: aload_0
    //   205: iconst_m1
    //   206: putfield 630	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:moveStartX	I
    //   209: aload_0
    //   210: iconst_m1
    //   211: putfield 632	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:moveStartY	I
    //   214: aload_0
    //   215: aconst_null
    //   216: putfield 176	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:outsideDragFromInfo	Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;
    //   219: aload_0
    //   220: iconst_0
    //   221: putfield 122	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:outsideDragCancel	Z
    //   224: aload_0
    //   225: iconst_m1
    //   226: putfield 270	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:startDragX	I
    //   229: aload_0
    //   230: iconst_m1
    //   231: putfield 272	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:startDragY	I
    //   234: aload_0
    //   235: iconst_0
    //   236: putfield 634	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:startDragYDiff	I
    //   239: aload_0
    //   240: iconst_m1
    //   241: putfield 88	com/tencent/mobileqq/mini/entry/desktop/widget/DragAdapter:mDeleteTarget	I
    //   244: goto +5 -> 249
    //   247: aload_1
    //   248: athrow
    //   249: goto -2 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	DragAdapter
    //   0	252	1	paramViewHolder	RecyclerView.ViewHolder
    //   0	252	2	paramInt	int
    //   12	36	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   54	67	147	finally
    //   152	162	147	finally
    //   54	67	151	java/lang/Throwable
  }
  
  public void onDragMove(int paramInt1, int paramInt2)
  {
    try
    {
      if (this.moveStartX <= 0) {
        this.moveStartX = paramInt1;
      }
      if (this.moveStartY <= 0) {
        this.moveStartY = paramInt2;
      }
      paramInt1 -= this.moveStartX;
      paramInt2 -= this.moveStartY;
      if ((Math.abs(paramInt1) > 0) || (Math.abs(paramInt2) > 0))
      {
        onDragMoveImpl(this.startDragX + paramInt1, this.startDragY + this.startDragYDiff + paramInt2);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DragAdapter", 1, "onDragMove exception!", localThrowable);
    }
  }
  
  public void onDragMoveImpl(int paramInt1, int paramInt2)
  {
    setDragMirrorPosition(paramInt1, paramInt2);
    this.mMainHandler.removeCallbacks(this.mMoveRunnable);
    if (paramInt1 >= this.mRecyclerView.getRight() - ViewUtils.dip2px(80.0F))
    {
      if (this.mRecyclerView.computeHorizontalScrollExtent() + this.mRecyclerView.computeHorizontalScrollOffset() < this.mRecyclerView.computeHorizontalScrollRange()) {
        this.mRecyclerView.startAutoScrollX(true);
      }
    }
    else
    {
      if (paramInt1 <= ViewUtils.dip2px(5.0F) * -1)
      {
        this.mRecyclerView.startAutoScrollX(false);
        return;
      }
      this.mRecyclerView.stopAutoScroll();
    }
    this.mMoveRunnable.setMoveAction(paramInt1, paramInt2);
    this.mMainHandler.postDelayed(this.mMoveRunnable, 200L);
  }
  
  public void onDragStart(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Desktop-Drag onDragStart from：");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("DragAdapter", 1, ((StringBuilder)localObject).toString());
    doVibrate();
    this.mDragIndex = paramInt;
    this.mDragViewHolder = paramViewHolder;
    if ((this.mDragMirrorLayout != null) && (this.mDragMirrorImage != null))
    {
      if (paramViewHolder != null) {
        paramViewHolder.itemView.setVisibility(4);
      }
      localObject = this.mDragMirrorMarkImage;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(4);
      }
      paramInt = getDragParentLeft(paramViewHolder);
      int i = getDragParentTop(paramViewHolder);
      int j = paramViewHolder.itemView.getLeft();
      int k = ViewUtils.dpToPx(8.0F);
      int m = paramViewHolder.itemView.getTop();
      int n = ViewUtils.dpToPx(8.0F);
      this.startDragX = (paramInt + j + k);
      this.startDragY = (i + m - n);
      setDragMirrorPosition(this.startDragX, this.startDragY);
      this.mDragMirrorLayout.clearAnimation();
      paramViewHolder = (DesktopAppInfo)this.mData.get(paramViewHolder.getAdapterPosition());
      this.mDragMirrorImage.setImageDrawable(MiniAppUtils.getIcon(this.mContext, paramViewHolder.mMiniAppInfo.iconUrl, true));
      this.mDragMirrorMarkImage.setImageResource(2130841805);
      this.mDragMirrorLayout.setVisibility(0);
      this.mDragMirrorLayout.setAnimation(this.mirrorZoomAnimation);
      this.mirrorZoomAnimation.start();
    }
  }
  
  public void onItemDelete(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Desktop-Drag onItemDelete target：");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("DragAdapter", 1, ((StringBuilder)localObject).toString());
    localObject = (DesktopAppInfo)this.mData.get(paramInt);
    MiniAppInfo localMiniAppInfo = ((DesktopAppInfo)localObject).mMiniAppInfo;
    if (((DesktopAppInfo)localObject).mModuleType == 3)
    {
      MiniAppCmdUtil.getInstance().setUserAppTop(localMiniAppInfo.appId, 0, localMiniAppInfo.verType, -1, -1, null, new DragAdapter.1(this));
      localObject = new MiniAppConfig(localMiniAppInfo);
      ((MiniAppConfig)localObject).launchParam.scene = 3003;
      MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject, "desktop", "delete", "delete_mine", null);
    }
    else
    {
      MiniAppCmdUtil.getInstance().delUserApp(localMiniAppInfo.appId, localMiniAppInfo.verType, localMiniAppInfo.recommend, 1, null, 1, new DragAdapter.2(this, localMiniAppInfo, (DesktopAppInfo)localObject));
      localObject = new MiniAppConfig(localMiniAppInfo);
      ((MiniAppConfig)localObject).launchParam.scene = 3001;
      MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject, "desktop", "delete", "delete_lately", null);
    }
    this.mData.remove(paramInt);
    notifyItemRemoved(paramInt);
    notifyItemRangeChanged(paramInt, getItemCount());
    paramInt = 0;
    while (paramInt < this.mData.size())
    {
      if (((DesktopItemInfo)this.mData.get(paramInt)).isTemp)
      {
        this.mData.remove(paramInt);
        notifyItemRemoved(paramInt);
        this.mIntertTarget = -1;
        return;
      }
      paramInt += 1;
    }
  }
  
  public void onItemDraw(RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2) {}
  
  public void onItemMoved(int paramInt1, int paramInt2)
  {
    if ((this.mMoveItemRunnable.moveFromIndex == paramInt1) && (this.mMoveItemRunnable.pendingMoveTargetIndex == paramInt2)) {
      return;
    }
    Object localObject = this.mDragMirrorLayout;
    int j = -1;
    int i;
    if (localObject != null)
    {
      i = ((View)localObject).getLeft();
    }
    else
    {
      localObject = this.mDragViewHolder;
      if (localObject != null) {
        i = ((RecyclerView.ViewHolder)localObject).itemView.getLeft();
      } else {
        i = -1;
      }
    }
    localObject = this.mDragMirrorLayout;
    if (localObject != null)
    {
      j = ((View)localObject).getTop();
    }
    else
    {
      localObject = this.mDragViewHolder;
      if (localObject != null) {
        j = ((RecyclerView.ViewHolder)localObject).itemView.getTop();
      }
    }
    if ((Math.abs(j - this.lastDragMoveLeft) <= ViewUtils.dpToPx(20.0F)) && (Math.abs(j - this.lastDragMoveTop) <= ViewUtils.dpToPx(20.0F))) {
      return;
    }
    this.lastDragMoveLeft = i;
    this.lastDragMoveTop = j;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Desktop-Drag Moved from ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" target ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" dragPos:");
    ((StringBuilder)localObject).append(getDragPosition());
    QLog.i("DragAdapter", 1, ((StringBuilder)localObject).toString());
    this.mMainHandler.removeCallbacks(this.mMoveItemRunnable);
    this.mMoveItemRunnable.setMoveAction(paramInt1, paramInt2);
    this.mMainHandler.postDelayed(this.mMoveItemRunnable, 200L);
  }
  
  public void onItemPrepared(int paramInt)
  {
    int i = 0;
    Object localObject;
    if (paramInt >= 0)
    {
      if (!this.mDeletePrepared)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Desktop-Drag onItemDeletePrepared target：");
        ((StringBuilder)localObject).append(paramInt);
        QLog.i("DragAdapter", 1, ((StringBuilder)localObject).toString());
        doVibrate();
        this.mDeletePrepared = true;
        localObject = this.mDragMirrorMarkImage;
        if (localObject != null)
        {
          ((ImageView)localObject).setImageResource(2130841804);
          this.mDragMirrorMarkImage.setVisibility(0);
        }
      }
    }
    else if (this.mDeletePrepared)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Desktop-Drag onItemDelete Prepared target：");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("DragAdapter", 1, ((StringBuilder)localObject).toString());
      this.mDeletePrepared = false;
      localObject = this.mDragMirrorMarkImage;
      if (localObject != null)
      {
        ((ImageView)localObject).setImageResource(2130841805);
        localObject = this.mDragMirrorMarkImage;
        paramInt = i;
        if (this.mIntertTarget <= 0) {
          if (shouldShowMirrorMask()) {
            paramInt = i;
          } else {
            paramInt = 4;
          }
        }
        ((ImageView)localObject).setVisibility(paramInt);
      }
    }
  }
  
  public void reset()
  {
    Object localObject = this.mDragViewHolder;
    if (localObject != null) {
      onDragFinish((RecyclerView.ViewHolder)localObject, this.mDragIndex);
    }
    localObject = this.mRecyclerView;
    if (localObject != null) {
      localObject = ((DragRecyclerView)localObject).getChildRecycleView();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DragRecyclerView localDragRecyclerView = (DragRecyclerView)((Iterator)localObject).next();
        if ((localDragRecyclerView.getAdapter() instanceof DragAdapter)) {
          ((DragAdapter)localDragRecyclerView.getAdapter()).reset();
        }
      }
    }
  }
  
  public void setDragAppInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, DesktopAppInfo paramDesktopAppInfo)
  {
    this.moveStartX = paramInt3;
    this.moveStartY = paramInt4;
    this.startDragX = paramInt1;
    this.startDragY = paramInt2;
    this.startDragYDiff = paramInt5;
    this.outsideDragFromInfo = paramDesktopAppInfo;
  }
  
  public void setDragMirrorView(View paramView)
  {
    this.mDragMirrorLayout = paramView;
    if (paramView != null)
    {
      this.mDragMirrorImage = ((ImageView)paramView.findViewById(2131438436));
      this.mDragMirrorMarkImage = ((ImageView)paramView.findViewById(2131438438));
      this.mDragMirrorMarkImage.setVisibility(4);
    }
  }
  
  public void setOutsideDragCancel(boolean paramBoolean)
  {
    this.outsideDragCancel = paramBoolean;
    this.mRecyclerView.stopAutoScroll();
  }
  
  public void setParentRecyclerView(DragRecyclerView paramDragRecyclerView)
  {
    this.mParentRecyclerView = paramDragRecyclerView;
  }
  
  protected void updateHolder(MiniAppDesktopAdapter.MicroAppViewHolder paramMicroAppViewHolder, DesktopAppInfo paramDesktopAppInfo, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DragAdapter
 * JD-Core Version:    0.7.0.1
 */