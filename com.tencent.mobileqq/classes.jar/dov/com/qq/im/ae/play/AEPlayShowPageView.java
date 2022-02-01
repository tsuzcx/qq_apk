package dov.com.qq.im.ae.play;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import bmxa;
import bnke;
import bnqc;
import bnqm;
import bnqq;
import bnrh;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.List;

public class AEPlayShowPageView
  extends FrameLayout
{
  private static final AEPlayShowGridAdapter.SizeInfo ONE_COLUMN_SIZE = calcSizeInfo(1);
  private static final String TAG = "AEPlayShowPageView";
  private static final AEPlayShowGridAdapter.SizeInfo TWO_COLUMN_SIZE = calcSizeInfo(2);
  private GridLayoutManager gridLayoutManager;
  private List<bnke> mInfoWrappers;
  private int mLayoutType = 2;
  private bnqc mPartManger;
  private AEPlayShowGridAdapter mPlayShowGridAdapter;
  private RecyclerView mPlayShowGridView;
  
  public AEPlayShowPageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, @NonNull bnqc parambnqc, int paramInt2, @NonNull List<bnke> paramList)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    initConfig(parambnqc, paramInt2, paramList);
    initViews(paramContext);
  }
  
  public AEPlayShowPageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @NonNull bnqc parambnqc, int paramInt, @NonNull List<bnke> paramList)
  {
    this(paramContext, paramAttributeSet, 0, parambnqc, paramInt, paramList);
  }
  
  public AEPlayShowPageView(@NonNull Context paramContext, @NonNull bnqc parambnqc, int paramInt, @NonNull List<bnke> paramList)
  {
    this(paramContext, null, parambnqc, paramInt, paramList);
  }
  
  private static AEPlayShowGridAdapter.SizeInfo calcSizeInfo(int paramInt)
  {
    int j = ViewUtils.dip2px(10.0F);
    int k = ViewUtils.dip2px(4.0F);
    int m = (int)(k * 0.96F);
    if (paramInt == 1) {}
    for (int i = ViewUtils.getScreenWidth() - j * 2 - k * 2;; i = (ViewUtils.getScreenWidth() - j * 2 - k * 4) / 2)
    {
      int n = (int)(i * 0.96F * 59.0F / 34.0F);
      AEPlayShowGridAdapter.SizeInfo localSizeInfo = new AEPlayShowGridAdapter.SizeInfo();
      localSizeInfo.itemWidth = (i + k * 2);
      localSizeInfo.itemHeight = (m * 2 + n);
      localSizeInfo.itemHorizontalPadding = k;
      localSizeInfo.itemVerticalPadding = m;
      if (paramInt == 1) {
        localSizeInfo.itemVerticalPadding = j;
      }
      return localSizeInfo;
    }
  }
  
  private void clearPositionFlag()
  {
    if (this.mPartManger == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.mPartManger.a(65537, new Object[0]);
      } while (!(localObject instanceof bmxa));
      localObject = (bmxa)localObject;
    } while ((((bmxa)localObject).a() == null) || (((bmxa)localObject).a().getIntent() == null));
    ((bmxa)localObject).a().getIntent().putExtra("KEY_CURRENT_SELECT_ID", "");
    ((bmxa)localObject).a().getIntent().putExtra("KEY_CURRENT_TYPE", "");
  }
  
  private void initConfig(@NonNull bnqc parambnqc, int paramInt, @NonNull List<bnke> paramList)
  {
    this.mPartManger = parambnqc;
    this.mLayoutType = paramInt;
    this.mInfoWrappers = paramList;
  }
  
  private void initViews(@NonNull Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131558548, this, true);
    this.mPlayShowGridView = ((RecyclerView)findViewById(2131362282));
    bnrh.a("AEPlayShowPart", "rv toString " + this.mPlayShowGridView.toString());
    this.mPlayShowGridView.addOnScrollListener(new AEPlayShowPageView.1(this));
    if (this.mLayoutType == 1)
    {
      this.gridLayoutManager = new GridLayoutManager(paramContext, 1, 1, false);
      this.mPlayShowGridView.setLayoutManager(this.gridLayoutManager);
      if (this.mLayoutType != 1) {
        break label198;
      }
    }
    label198:
    for (AEPlayShowGridAdapter.SizeInfo localSizeInfo = new AEPlayShowGridAdapter.SizeInfo(ONE_COLUMN_SIZE);; localSizeInfo = new AEPlayShowGridAdapter.SizeInfo(TWO_COLUMN_SIZE))
    {
      this.mPlayShowGridView.addItemDecoration(new AEPlayShowPageView.2(this, localSizeInfo));
      this.mPlayShowGridAdapter = new AEPlayShowGridAdapter(paramContext, this.mPartManger, localSizeInfo, this.mLayoutType);
      this.mPlayShowGridView.setAdapter(this.mPlayShowGridAdapter);
      updateData(this.mInfoWrappers);
      return;
      this.gridLayoutManager = new GridLayoutManager(paramContext, 2, 1, false);
      break;
    }
  }
  
  public int getCurrentY()
  {
    if (this.mPlayShowGridView == null) {
      return 0;
    }
    return this.mPlayShowGridView.getScrollY();
  }
  
  public void initDownloadObservers()
  {
    this.mPlayShowGridAdapter.initObservers();
  }
  
  public void onDestroy()
  {
    if (this.mPlayShowGridView != null) {
      this.mPlayShowGridView.removeCallbacks(null);
    }
    if (this.mPlayShowGridAdapter != null) {
      this.mPlayShowGridAdapter.onDestroy();
    }
  }
  
  public void reportItemExpose()
  {
    int i = this.gridLayoutManager.findFirstVisibleItemPosition();
    int j = this.gridLayoutManager.findLastVisibleItemPosition();
    if ((this.mInfoWrappers == null) || (i < 0) || (j < 0)) {}
    for (;;)
    {
      return;
      while ((i < this.mInfoWrappers.size()) && (i <= j))
      {
        bnke localbnke = (bnke)this.mInfoWrappers.get(i);
        bnqq.a().d(localbnke.g);
        bnqq.a().c(i + 1);
        bnqm.a().g(localbnke.a);
        i += 1;
      }
    }
  }
  
  public void scrollTo(int paramInt)
  {
    if (this.mPlayShowGridView != null) {
      this.mPlayShowGridView.scrollTo(0, paramInt);
    }
  }
  
  public void scrollToPosWithClick(int paramInt)
  {
    if (this.mPlayShowGridView != null)
    {
      if (this.gridLayoutManager != null) {
        this.gridLayoutManager.scrollToPositionWithOffset(paramInt, 0);
      }
      bnrh.a("AEPlayShowPart", "out........" + this.mPlayShowGridView.toString());
      this.mPlayShowGridView.post(new AEPlayShowPageView.3(this, paramInt));
    }
  }
  
  public void setTabId(String paramString)
  {
    this.mPlayShowGridAdapter.setCurTabId(paramString);
  }
  
  public void updateData(@NonNull List<bnke> paramList)
  {
    if (this.mPlayShowGridAdapter != null) {
      this.mPlayShowGridAdapter.putData(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowPageView
 * JD-Core Version:    0.7.0.1
 */