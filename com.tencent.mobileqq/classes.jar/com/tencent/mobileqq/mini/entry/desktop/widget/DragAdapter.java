package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import aoom;
import bdoo;
import com.tencent.common.app.AppInterface;
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
  public List<DesktopItemInfo> mData = new ArrayList();
  private boolean mDeletePrepared;
  protected int mDeleteTarget = -1;
  public int mDragIndex = -1;
  protected ImageView mDragMirrorImage;
  public View mDragMirrorLayout;
  protected ImageView mDragMirrorMarkImage;
  private RecyclerView.ViewHolder mDragViewHolder;
  private int mIntertFrom = -1;
  private int mIntertTarget = -1;
  private Handler mMainHandler = new Handler(Looper.getMainLooper());
  private DragAdapter.MoveItemRunnable mMoveItemRunnable = new DragAdapter.MoveItemRunnable(this, null);
  private DragAdapter.MoveRunnable mMoveRunnable = new DragAdapter.MoveRunnable(this);
  protected DragRecyclerView mParentRecyclerView;
  public DragRecyclerView mRecyclerView;
  private Vibrator mVibrator;
  protected ScaleAnimation mirrorRevertAnimation = new ScaleAnimation(1.2F, 1.0F, 1.2F, 1.0F, 1, 0.5F, 1, 0.5F);
  protected ScaleAnimation mirrorZoomAnimation = new ScaleAnimation(1.0F, 1.2F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
  protected int moveStartX;
  protected int moveStartY;
  protected boolean outsideDragCancel;
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
    int i;
    if (this.mDragViewHolder != null)
    {
      paramInt = this.mDragViewHolder.itemView.getLeft();
      if (this.mDragViewHolder == null) {
        break label518;
      }
      i = this.mDragViewHolder.itemView.getTop();
      label36:
      if (this.mDragMirrorLayout == null) {
        break label1269;
      }
      paramInt = this.mDragMirrorLayout.getLeft();
      i = this.mDragMirrorLayout.getTop();
    }
    label95:
    label1254:
    label1262:
    label1269:
    for (;;)
    {
      boolean bool1 = isSameModule(this.mDragIndex, this.mIntertTarget);
      int j;
      int k;
      Object localObject1;
      Object localObject2;
      if ((!this.mDeletePrepared) && ((bool1) || (this.mIntertTarget < 0)))
      {
        j = 1;
        boolean bool2 = isDragCancel();
        if (bool2)
        {
          QLog.i("DragAdapter", 1, "Desktop-Drag onDragFinish isDragCancel：" + bool2);
          k = 0;
          if (k < this.mData.size())
          {
            if (!((DesktopItemInfo)this.mData.get(k)).isTemp) {
              break label555;
            }
            if (!bool1) {
              break label529;
            }
            ((DesktopItemInfo)this.mData.get(k)).setIsTemp(false);
            notifyItemChanged(k);
            this.mIntertTarget = -1;
          }
        }
        paramViewHolder = this.mDragViewHolder;
        if (this.mDragMirrorLayout == null) {
          break label688;
        }
        this.mDragMirrorLayout.clearAnimation();
        if (j != 0) {
          break label564;
        }
        this.mDragMirrorLayout.setVisibility(4);
        if (this.mDragViewHolder != null)
        {
          this.mDragViewHolder.itemView.setVisibility(0);
          this.mDragViewHolder.itemView.setAlpha(0.0F);
          this.mMainHandler.postDelayed(new DragAdapter.3(this, paramViewHolder), 350L);
        }
        if ((this.mIntertTarget >= 0) && (!this.mDeletePrepared))
        {
          if (!((DesktopItemInfo)this.mData.get(this.mIntertTarget) instanceof DesktopEmptyGuideInfo)) {
            break label781;
          }
          if (this.outsideDragFromInfo == null) {
            break label709;
          }
          paramViewHolder = this.outsideDragFromInfo;
          localObject1 = new DesktopAppGroupInfo(3);
          localObject2 = new ArrayList();
          ((List)localObject2).add(new DesktopAppInfo(3, paramViewHolder.mMiniAppInfo));
          ((DesktopAppGroupInfo)localObject1).setData((List)localObject2);
          this.mData.set(this.mIntertTarget, localObject1);
          notifyItemChanged(this.mIntertTarget);
        }
      }
      for (;;)
      {
        try
        {
          ((DesktopDataManager)MiniAppUtils.getAppInterface().getManager(336)).onItemChanged(this.mIntertTarget, new DesktopAppInfo(3, paramViewHolder.mMiniAppInfo));
          MiniAppCmdUtil.getInstance().setUserAppTop(paramViewHolder.mMiniAppInfo.appId, 1, paramViewHolder.mMiniAppInfo.verType, -1, 0, null, new DragAdapter.5(this));
          localObject1 = new MiniAppConfig(paramViewHolder.mMiniAppInfo);
          if (paramViewHolder.getModuleType() == 1)
          {
            ((MiniAppConfig)localObject1).launchParam.scene = 3001;
            MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject1, "desktop", "add", "add_lately", null);
            return;
            paramInt = 0;
            break;
            i = 0;
            break label36;
            j = 0;
            break label95;
            this.mData.remove(k);
            notifyItemRemoved(k);
            this.mIntertTarget = -1;
            break label203;
            k += 1;
            break label135;
            if (!bool1)
            {
              localObject1 = new AnimationSet(true);
              ((AnimationSet)localObject1).addAnimation(this.mirrorRevertAnimation);
              localObject2 = new TranslateAnimation(0.0F, this.startDragX - paramInt, 0.0F, this.startDragY - i);
              ((TranslateAnimation)localObject2).setDuration(200L);
              ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
              ((AnimationSet)localObject1).setAnimationListener(new DragAdapter.4(this, paramViewHolder));
              this.mDragMirrorLayout.setAnimation((Animation)localObject1);
              ((AnimationSet)localObject1).start();
              break label284;
            }
            if (this.mDragViewHolder != null) {
              this.mDragViewHolder.itemView.setVisibility(0);
            }
            this.mDragMirrorLayout.setVisibility(4);
            break label284;
            if (this.mDragViewHolder == null) {
              break label284;
            }
            this.mDragViewHolder.itemView.setVisibility(0);
            break label284;
            paramViewHolder = (DesktopAppInfo)this.mData.get(this.mDragIndex);
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("DragAdapter", 1, localThrowable, new Object[0]);
          continue;
          if (paramViewHolder.getModuleType() != 2) {
            continue;
          }
          localThrowable.launchParam.scene = 3002;
          MiniProgramLpReportDC04239.reportAsync(localThrowable, "desktop", "add", "add_recommend", null);
          return;
        }
        if (getItemCount() > aoom.c())
        {
          paramInt = this.mIntertTarget;
          this.mMainHandler.post(new DragAdapter.6(this, paramInt));
          return;
        }
        DesktopAppInfo localDesktopAppInfo = (DesktopAppInfo)this.mData.get(this.mIntertTarget);
        if (localDesktopAppInfo.isTemp) {
          localDesktopAppInfo.setIsTemp(false);
        }
        try
        {
          notifyItemChanged(this.mIntertTarget);
          m = ((DesktopDataManager)MiniAppUtils.getAppInterface().getManager(336)).getTopModuleInfoIndex();
          j = this.mDragIndex;
          k = this.mIntertTarget;
          i = j;
          paramInt = k;
          if (this.mParentRecyclerView != null)
          {
            i = j;
            paramInt = k;
            if (this.mParentRecyclerView.getAdapter() != null)
            {
              i = j;
              paramInt = k;
              if (this.mDragIndex < 0)
              {
                i = -1;
                paramInt = this.mIntertTarget;
              }
            }
          }
          MiniAppCmdUtil.getInstance().setUserAppTop(localDesktopAppInfo.mMiniAppInfo.appId, 1, localDesktopAppInfo.mMiniAppInfo.verType, i, paramInt, null, new DragAdapter.8(this));
          if (this.outsideDragFromInfo != null)
          {
            paramViewHolder = this.outsideDragFromInfo;
            if (paramViewHolder != null)
            {
              localObject2 = new MiniAppConfig(paramViewHolder.mMiniAppInfo);
              if (paramViewHolder.getModuleType() != 1) {
                break label1217;
              }
              ((MiniAppConfig)localObject2).launchParam.scene = 3001;
              MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject2, "desktop", "add", "add_lately", null);
            }
            if (this.mDeletePrepared) {
              continue;
            }
            if ((this.mParentRecyclerView == null) || (this.mParentRecyclerView.getAdapter() == null)) {
              break label1254;
            }
            paramInt = 0;
            if ((paramInt >= getItemCount()) || ((this.mData.get(paramInt) instanceof DesktopAppModuleInfo))) {
              continue;
            }
            if ((!(this.mData.get(paramInt) instanceof DesktopAppInfo)) || (paramInt == this.mIntertTarget)) {
              break label1262;
            }
            paramViewHolder = (DesktopAppInfo)this.mData.get(paramInt);
            if (!localDesktopAppInfo.mMiniAppInfo.equals(paramViewHolder.mMiniAppInfo)) {
              break label1262;
            }
            this.mData.remove(paramInt);
            notifyItemRemoved(paramInt);
            notifyItemRangeChanged(paramInt, getItemCount());
          }
        }
        catch (Throwable paramViewHolder)
        {
          for (;;)
          {
            int m;
            QLog.e("DragAdapter", 1, "onDragFinish exception!", paramViewHolder);
            paramInt = this.mIntertTarget;
            this.mMainHandler.postDelayed(new DragAdapter.7(this, paramInt), 200L);
            continue;
            paramViewHolder = (DesktopAppInfo)this.mData.get(this.mDragIndex);
            continue;
            if (paramViewHolder.getModuleType() == 2)
            {
              ((MiniAppConfig)localObject2).launchParam.scene = 3002;
              MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject2, "desktop", "add", "add_recommend", null);
              continue;
              paramInt = m + 1;
              continue;
              paramInt += 1;
            }
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
      if (this.mVibrator != null) {
        this.mVibrator.vibrate(50L);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DragAdapter", 1, "exception when doVibrate.", localThrowable);
    }
  }
  
  private boolean isSameModule(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= getItemCount()) || (paramInt2 < 0) || (paramInt2 >= getItemCount())) {
      return false;
    }
    DesktopItemInfo localDesktopItemInfo1 = (DesktopItemInfo)this.mData.get(paramInt1);
    DesktopItemInfo localDesktopItemInfo2 = (DesktopItemInfo)this.mData.get(paramInt2);
    return localDesktopItemInfo1.mModuleType == localDesktopItemInfo2.mModuleType;
  }
  
  private void setDragMirrorPosition(int paramInt1, int paramInt2)
  {
    if ((this.mDragMirrorLayout != null) && (this.mDragMirrorImage != null))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mDragMirrorLayout.getLayoutParams();
      localLayoutParams.setMargins(paramInt1, paramInt2, 0, 0);
      this.mDragMirrorLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  private boolean shouldShowMirrorMask()
  {
    if (this.mParentRecyclerView != null) {}
    for (Object localObject1 = this.mParentRecyclerView.getChildRecycleView();; localObject1 = this.mRecyclerView.getChildRecycleView())
    {
      localObject1 = ((List)localObject1).iterator();
      Object localObject2;
      do
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (DragRecyclerView)((Iterator)localObject1).next();
        } while (!(((DragRecyclerView)localObject2).getAdapter() instanceof DragAdapter));
        localObject2 = (DragAdapter)((DragRecyclerView)localObject2).getAdapter();
      } while ((((DragAdapter)localObject2).mIntertTarget <= 0) && (!((DragAdapter)localObject2).mDeletePrepared));
      return true;
    }
    return false;
  }
  
  protected void doDragMove(int paramInt1, int paramInt2)
  {
    Object localObject3 = findChildViewAt(paramInt1, paramInt2);
    if (localObject3 != null) {}
    label254:
    Object localObject2;
    for (Object localObject1 = this.mRecyclerView.getChildViewHolder((View)localObject3);; localObject2 = null)
    {
      int n = -1;
      int m = -1;
      int k = n;
      int i;
      int j;
      if (localObject1 != null)
      {
        i = ((RecyclerView.ViewHolder)localObject1).getAdapterPosition();
        DesktopItemInfo localDesktopItemInfo = (DesktopItemInfo)this.mData.get(i);
        j = n;
        if (localDesktopItemInfo.dropEnable)
        {
          j = n;
          if (!localDesktopItemInfo.isTemp) {
            j = i;
          }
        }
        k = j;
        m = i;
        if (paramInt1 > ((View)localObject3).getLeft() + ((View)localObject3).getWidth() * 0.66D) {
          if (i + 1 < this.mData.size())
          {
            localObject3 = (DesktopItemInfo)this.mData.get(i + 1);
            k = j;
            if (((DesktopItemInfo)localObject3).dropEnable)
            {
              k = j;
              if (!((DesktopItemInfo)localObject3).isTemp) {
                k = i + 1;
              }
            }
            m = i;
            i = 0;
            j = k;
            k = m;
          }
        }
      }
      for (;;)
      {
        if ((j >= 0) && (j != this.mDragIndex)) {
          if (this.mIntertTarget < 0)
          {
            QLog.i("DragAdapter", 1, "Desktop-Drag onDragInsert target：" + j);
            boolean bool;
            if (this.outsideDragFromInfo != null)
            {
              localObject1 = this.outsideDragFromInfo;
              if (this.mDragIndex < 0) {
                break label376;
              }
              bool = isSameModule(this.mDragIndex, j);
            }
            for (;;)
            {
              if (localObject1 != null)
              {
                if (!bool) {
                  break label816;
                }
                if (this.mDragIndex < j)
                {
                  k = this.mDragIndex;
                  while (k < j)
                  {
                    Collections.swap(this.mData, k, k + 1);
                    k += 1;
                  }
                  j = -1;
                  m = 1;
                  k = i;
                  i = m;
                  break;
                  if (this.mDragIndex >= 0)
                  {
                    localObject1 = (DesktopAppInfo)this.mData.get(this.mDragIndex);
                    break label254;
                  }
                  localObject1 = null;
                  break label254;
                  label376:
                  bool = false;
                  continue;
                }
                k = this.mDragIndex;
                while (k > j)
                {
                  Collections.swap(this.mData, k, k - 1);
                  k -= 1;
                }
                QLog.i("DragAdapter", 1, "Desktop-Drag OP_SWAP fromOld:" + this.mIntertTarget + " target:" + j);
                ((DesktopItemInfo)this.mData.get(j)).setIsTemp(true);
                notifyItemMoved(this.mDragIndex, j);
                this.mDragIndex = j;
                this.mIntertTarget = j;
              }
            }
          }
        }
        for (;;)
        {
          if (this.mDragMirrorMarkImage != null)
          {
            if ((this.mIntertTarget > 0) || (i != 0))
            {
              j = 1;
              label518:
              if ((j == 0) && (!shouldShowMirrorMask())) {
                break label1078;
              }
              this.mDragMirrorMarkImage.setVisibility(0);
            }
          }
          else {
            label538:
            if ((Math.abs(paramInt1 - this.lastDragLeft) > bdoo.b(5.0F)) || (Math.abs(paramInt2 - this.lastDragTop) > bdoo.b(5.0F)))
            {
              this.lastDragLeft = paramInt1;
              this.lastDragTop = paramInt2;
            }
          }
          try
          {
            if (this.mIntertTarget < 0)
            {
              localObject1 = this.mRecyclerView.findViewHolderForAdapterPosition(getItemCount() - 1);
              if ((i != 0) || ((localObject1 != null) && (paramInt1 - ((RecyclerView.ViewHolder)localObject1).itemView.getLeft() >= bdoo.b(20.0F)) && (paramInt2 - ((RecyclerView.ViewHolder)localObject1).itemView.getTop() >= bdoo.b(5.0F))))
              {
                localObject3 = (DesktopItemInfo)this.mData.get(getItemCount() - 1);
                if ((((DesktopItemInfo)localObject3).dropEnable) && (!((DesktopItemInfo)localObject3).isTemp) && (!isSameModule(this.mDragIndex, getItemCount() - 1)))
                {
                  QLog.i("DragAdapter", 1, "Desktop-Drag into tail blank area from:" + this.mDragIndex);
                  if (this.outsideDragFromInfo == null) {
                    break label1089;
                  }
                }
              }
            }
            label816:
            label1078:
            label1089:
            for (localObject1 = this.outsideDragFromInfo;; localObject1 = (DesktopAppInfo)this.mData.get(this.mDragIndex))
            {
              localObject1 = new DesktopAppInfo(((DesktopItemInfo)localObject3).mModuleType, ((DesktopAppInfo)localObject1).mMiniAppInfo);
              ((DesktopItemInfo)localObject1).setIsTemp(true);
              this.mData.add(localObject1);
              this.mIntertTarget = (this.mData.size() - 1);
              notifyItemInserted(this.mData.size() - 1);
              return;
              this.mIntertTarget = j;
              localObject1 = new DesktopAppInfo(((DesktopAppInfo)this.mData.get(j)).mModuleType, ((DesktopAppInfo)localObject1).mMiniAppInfo);
              ((DesktopItemInfo)localObject1).setIsTemp(true);
              this.mData.add(j, localObject1);
              notifyItemInserted(j);
              break;
              if (j == this.mIntertTarget) {
                break;
              }
              if (this.mIntertTarget < j)
              {
                k = this.mIntertTarget;
                while (k < j)
                {
                  Collections.swap(this.mData, k, k + 1);
                  k += 1;
                }
              }
              k = this.mIntertTarget;
              while (k > j)
              {
                Collections.swap(this.mData, k, k - 1);
                k -= 1;
              }
              QLog.i("DragAdapter", 1, "Desktop-Drag OP_SWAP fromOld:" + this.mIntertTarget + " target:" + j);
              notifyItemMoved(this.mIntertTarget, j);
              this.mIntertTarget = j;
              break;
              if ((localObject1 instanceof MiniAppDesktopAdapter.ModuleGuideViewHolder))
              {
                this.mIntertTarget = k;
                break;
              }
              if ((this.mIntertTarget <= 0) || (getItemViewType(this.mIntertTarget) != 4)) {
                break;
              }
              this.mIntertTarget = -1;
              break;
              j = 0;
              break label518;
              this.mDragMirrorMarkImage.setVisibility(4);
              break label538;
            }
            i = 0;
          }
          catch (Throwable localThrowable)
          {
            QLog.e("DragAdapter", 1, localThrowable, new Object[0]);
            return;
          }
        }
        j = k;
        k = m;
      }
    }
  }
  
  public View findChildViewAt(float paramFloat1, float paramFloat2)
  {
    int i = (int)paramFloat1;
    int j = (int)paramFloat2;
    int k = bdoo.a(45.0F);
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
  
  protected boolean isDragCancel()
  {
    boolean bool2 = false;
    int i;
    if (this.mDragViewHolder != null)
    {
      i = this.mDragViewHolder.itemView.getLeft();
      if (this.mDragViewHolder == null) {
        break label120;
      }
    }
    label120:
    for (int j = this.mDragViewHolder.itemView.getTop();; j = 0)
    {
      if (this.mDragMirrorLayout != null)
      {
        i = this.mDragMirrorLayout.getLeft();
        j = this.mDragMirrorLayout.getTop();
      }
      boolean bool1;
      if (!this.outsideDragCancel)
      {
        bool1 = bool2;
        if (Math.abs(this.startDragX - i) < bdoo.b(15.0F))
        {
          bool1 = bool2;
          if (Math.abs(this.startDragY - j) >= bdoo.b(15.0F)) {}
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      i = 0;
      break;
    }
  }
  
  public boolean isDropable()
  {
    return (this.mData != null) && (this.mData.size() > 0) && (((DesktopItemInfo)this.mData.get(0)).dropEnable);
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
    return paramInt2 >= this.mRecyclerView.getHeight() - this.mRecyclerView.getResources().getDimensionPixelSize(2131296810);
  }
  
  public void onDragFinish(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder == null) {
      return;
    }
    QLog.i("DragAdapter", 1, "Desktop-Drag onDragFinish from:" + paramInt + " target:" + this.mIntertTarget);
    try
    {
      doOnDragFinish(paramViewHolder, paramInt);
      this.mRecyclerView.stopAutoScroll();
      return;
    }
    catch (Throwable paramViewHolder)
    {
      QLog.e("DragAdapter", 1, "Desktop-Drag onDragFinish exception!", paramViewHolder);
      return;
    }
    finally
    {
      this.mDragIndex = -1;
      this.mDragViewHolder = null;
      this.mIntertFrom = -1;
      this.mIntertTarget = -1;
      this.mMoveItemRunnable.reset();
      this.mMoveRunnable.reset();
      this.mDeletePrepared = false;
      this.moveStartX = -1;
      this.moveStartY = -1;
      this.outsideDragFromInfo = null;
      this.outsideDragCancel = false;
      this.startDragX = -1;
      this.startDragY = -1;
      this.startDragYDiff = 0;
      this.mDeleteTarget = -1;
    }
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
      if ((Math.abs(paramInt1) > 0) || (Math.abs(paramInt2) > 0)) {
        onDragMoveImpl(paramInt1 + this.startDragX, paramInt2 + (this.startDragY + this.startDragYDiff));
      }
      return;
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
    if (paramInt1 >= this.mRecyclerView.getRight() - bdoo.a(80.0F))
    {
      if (this.mRecyclerView.computeHorizontalScrollExtent() + this.mRecyclerView.computeHorizontalScrollOffset() < this.mRecyclerView.computeHorizontalScrollRange()) {
        this.mRecyclerView.startAutoScrollX(true);
      }
    }
    else
    {
      if (paramInt1 <= bdoo.a(5.0F) * -1)
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
    if (paramViewHolder == null) {}
    do
    {
      return;
      QLog.i("DragAdapter", 1, "Desktop-Drag onDragStart from：" + paramInt);
      doVibrate();
      this.mDragIndex = paramInt;
      this.mDragViewHolder = paramViewHolder;
    } while ((this.mDragMirrorLayout == null) || (this.mDragMirrorImage == null));
    if (paramViewHolder != null) {
      paramViewHolder.itemView.setVisibility(4);
    }
    if (this.mDragMirrorMarkImage != null) {
      this.mDragMirrorMarkImage.setVisibility(4);
    }
    paramInt = getDragParentLeft(paramViewHolder);
    int i = getDragParentTop(paramViewHolder);
    int j = paramViewHolder.itemView.getLeft();
    int k = bdoo.b(8.0F);
    int m = paramViewHolder.itemView.getTop();
    int n = bdoo.b(8.0F);
    this.startDragX = (paramInt + j + k);
    this.startDragY = (i + m - n);
    setDragMirrorPosition(this.startDragX, this.startDragY);
    this.mDragMirrorLayout.clearAnimation();
    paramViewHolder = (DesktopAppInfo)this.mData.get(paramViewHolder.getAdapterPosition());
    this.mDragMirrorImage.setImageDrawable(MiniAppUtils.getIcon(this.mContext, paramViewHolder.mMiniAppInfo.iconUrl, true));
    this.mDragMirrorMarkImage.setImageResource(2130840725);
    this.mDragMirrorLayout.setVisibility(0);
    this.mDragMirrorLayout.setAnimation(this.mirrorZoomAnimation);
    this.mirrorZoomAnimation.start();
  }
  
  public void onItemDelete(int paramInt)
  {
    QLog.i("DragAdapter", 1, "Desktop-Drag onItemDelete target：" + paramInt);
    Object localObject = (DesktopAppInfo)this.mData.get(paramInt);
    MiniAppInfo localMiniAppInfo = ((DesktopAppInfo)localObject).mMiniAppInfo;
    if (((DesktopAppInfo)localObject).mModuleType == 3)
    {
      MiniAppCmdUtil.getInstance().setUserAppTop(localMiniAppInfo.appId, 0, localMiniAppInfo.verType, -1, -1, null, new DragAdapter.1(this));
      localObject = new MiniAppConfig(localMiniAppInfo);
      ((MiniAppConfig)localObject).launchParam.scene = 3003;
      MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject, "desktop", "delete", "delete_mine", null);
      this.mData.remove(paramInt);
      notifyItemRemoved(paramInt);
      notifyItemRangeChanged(paramInt, getItemCount());
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt < this.mData.size())
      {
        if (((DesktopItemInfo)this.mData.get(paramInt)).isTemp)
        {
          this.mData.remove(paramInt);
          notifyItemRemoved(paramInt);
          this.mIntertTarget = -1;
        }
      }
      else
      {
        return;
        MiniAppCmdUtil.getInstance().delUserApp(localMiniAppInfo.appId, localMiniAppInfo.verType, localMiniAppInfo.recommend, 1, null, 1, new DragAdapter.2(this, localMiniAppInfo, (DesktopAppInfo)localObject));
        localObject = new MiniAppConfig(localMiniAppInfo);
        ((MiniAppConfig)localObject).launchParam.scene = 3001;
        MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject, "desktop", "delete", "delete_lately", null);
        break;
      }
      paramInt += 1;
    }
  }
  
  public void onItemDraw(RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2) {}
  
  public void onItemMoved(int paramInt1, int paramInt2)
  {
    int j = -1;
    if ((this.mMoveItemRunnable.moveFromIndex == paramInt1) && (this.mMoveItemRunnable.pendingMoveTargetIndex == paramInt2)) {}
    label220:
    label240:
    for (;;)
    {
      return;
      int i;
      if (this.mDragMirrorLayout != null)
      {
        i = this.mDragMirrorLayout.getLeft();
        if (this.mDragMirrorLayout == null) {
          break label220;
        }
        j = this.mDragMirrorLayout.getTop();
      }
      for (;;)
      {
        if ((Math.abs(j - this.lastDragMoveLeft) <= bdoo.b(20.0F)) && (Math.abs(j - this.lastDragMoveTop) <= bdoo.b(20.0F))) {
          break label240;
        }
        this.lastDragMoveLeft = i;
        this.lastDragMoveTop = j;
        QLog.i("DragAdapter", 1, "Desktop-Drag Moved from " + paramInt1 + " target " + paramInt2 + " dragPos:" + this.mDragViewHolder.getAdapterPosition());
        this.mMainHandler.removeCallbacks(this.mMoveItemRunnable);
        this.mMoveItemRunnable.setMoveAction(paramInt1, paramInt2);
        this.mMainHandler.postDelayed(this.mMoveItemRunnable, 200L);
        return;
        if (this.mDragViewHolder != null)
        {
          i = this.mDragViewHolder.itemView.getLeft();
          break;
        }
        i = -1;
        break;
        if (this.mDragViewHolder != null) {
          j = this.mDragViewHolder.itemView.getTop();
        }
      }
    }
  }
  
  public void onItemPrepared(int paramInt)
  {
    int i = 0;
    if (paramInt >= 0) {
      if (!this.mDeletePrepared)
      {
        QLog.i("DragAdapter", 1, "Desktop-Drag onItemDeletePrepared target：" + paramInt);
        doVibrate();
        this.mDeletePrepared = true;
        if (this.mDragMirrorMarkImage != null)
        {
          this.mDragMirrorMarkImage.setImageResource(2130840724);
          this.mDragMirrorMarkImage.setVisibility(0);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (!this.mDeletePrepared);
      QLog.i("DragAdapter", 1, "Desktop-Drag onItemDelete Prepared target：" + paramInt);
      this.mDeletePrepared = false;
    } while (this.mDragMirrorMarkImage == null);
    this.mDragMirrorMarkImage.setImageResource(2130840725);
    ImageView localImageView = this.mDragMirrorMarkImage;
    paramInt = i;
    if (this.mIntertTarget <= 0) {
      if (!shouldShowMirrorMask()) {
        break label158;
      }
    }
    label158:
    for (paramInt = i;; paramInt = 4)
    {
      localImageView.setVisibility(paramInt);
      return;
    }
  }
  
  public void reset()
  {
    if (this.mDragViewHolder != null) {
      onDragFinish(this.mDragViewHolder, this.mDragIndex);
    }
    if (this.mRecyclerView != null) {}
    for (Object localObject = this.mRecyclerView.getChildRecycleView();; localObject = null)
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
      this.mDragMirrorImage = ((ImageView)paramView.findViewById(2131370463));
      this.mDragMirrorMarkImage = ((ImageView)paramView.findViewById(2131370465));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DragAdapter
 * JD-Core Version:    0.7.0.1
 */