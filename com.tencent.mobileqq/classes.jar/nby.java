import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.avgame.gameroom.gamelist.GameGridItemView;
import com.tencent.avgame.gameroom.gamelist.GameListRecyclerViewAdapter.1;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class nby
  extends RecyclerView.Adapter<nca>
{
  protected int a;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private LruCache<String, URLDrawable> jdField_a_of_type_AndroidUtilLruCache = new LruCache(20);
  protected LayoutInflater a;
  private View jdField_a_of_type_AndroidViewView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GameListRecyclerViewAdapter.1(this);
  protected List<mzj> a;
  protected nbp a;
  protected nbs a;
  protected boolean a;
  private int jdField_b_of_type_Int;
  private LruCache<String, URLDrawable> jdField_b_of_type_AndroidUtilLruCache = new LruCache(20);
  
  public nby(Context paramContext, RecyclerView paramRecyclerView, nbs paramnbs, nbp paramnbp)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Nbp = paramnbp;
    this.jdField_a_of_type_Nbs = paramnbs;
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) && (this.jdField_a_of_type_AndroidAnimationAnimatorSet.isRunning()))
    {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.removeAllListeners();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public mzj a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (mzj)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public nca a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558730, null);
    GameGridItemView localGameGridItemView = (GameGridItemView)paramViewGroup.findViewById(2131367354);
    localGameGridItemView.a(this.jdField_a_of_type_Nbs);
    return new nca(paramViewGroup, localGameGridItemView);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameListRecyclerViewAdapter", 2, "pauseAnimation: " + this.jdField_a_of_type_Int);
    }
    b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    int i = nbo.k;
    int j = bhtq.a(4.0F);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setPadding(nbo.k, nbo.l, i - j, nbo.m);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(this.jdField_a_of_type_AndroidContentContext, paramInt));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this);
  }
  
  public void a(List<mzj> paramList, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameListRecyclerViewAdapter", 2, "gameList: " + paramList + " isHost:" + paramBoolean + " currentGameIndex:" + paramInt);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    a(paramBoolean, paramInt, true);
  }
  
  public void a(nca paramnca, int paramInt)
  {
    Object localObject1 = paramnca.a.getLayoutParams();
    int i;
    mzj localmzj;
    label100:
    Object localObject2;
    if ((localObject1 instanceof FrameLayout.LayoutParams))
    {
      ((ViewGroup.LayoutParams)localObject1).width = nbo.i;
      ((ViewGroup.LayoutParams)localObject1).height = nbo.j;
      if (paramInt % this.jdField_b_of_type_Int == 0)
      {
        i = 51;
        ((FrameLayout.LayoutParams)localObject1).gravity = i;
      }
    }
    else
    {
      paramnca.itemView.setPadding(0, 0, 0, nbo.n);
      localmzj = (mzj)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (TextUtils.isEmpty(localmzj.k)) {
        break label375;
      }
      localObject1 = localmzj.k;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label429;
      }
      localObject2 = (URLDrawable)this.jdField_a_of_type_AndroidUtilLruCache.get(localObject1);
      if (localObject2 != null) {
        break label422;
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        localObject2 = nhs.a("avgame_list_card_bg_small@2x.png");
        if (localObject2 == null) {
          break label385;
        }
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable((Bitmap)localObject2);
      }
      label160:
      localObject2 = URLDrawable.getDrawable((String)localObject1, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      ((URLDrawable)localObject2).startDownload();
      this.jdField_a_of_type_AndroidUtilLruCache.put(localObject1, localObject2);
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localmzj.l))
      {
        localObject2 = (URLDrawable)this.jdField_b_of_type_AndroidUtilLruCache.get(localmzj.l);
        if (localObject2 == null)
        {
          localObject2 = URLDrawable.getDrawable(localmzj.l, beyq.jdField_a_of_type_AndroidGraphicsDrawableDrawable, beyq.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          ((URLDrawable)localObject2).startDownload();
          this.jdField_b_of_type_AndroidUtilLruCache.put(localmzj.l, localObject2);
        }
      }
      for (;;)
      {
        paramnca.a.a(localmzj, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, paramInt, (URLDrawable)localObject2, (URLDrawable)localObject1);
        paramnca.itemView.setScaleX(1.0F);
        paramnca.itemView.setScaleY(1.0F);
        if (paramInt == this.jdField_a_of_type_Int)
        {
          b();
          this.jdField_a_of_type_AndroidViewView = paramnca.itemView;
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
        }
        for (;;)
        {
          EventCollector.getInstance().onRecyclerBindViewHolder(paramnca, paramInt, getItemId(paramInt));
          return;
          if ((paramInt + 1) % this.jdField_b_of_type_Int == 0)
          {
            i = 53;
            break;
          }
          i = 49;
          break;
          label375:
          localObject1 = localmzj.c;
          break label100;
          label385:
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = beyq.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          break label160;
          if (this.jdField_a_of_type_AndroidViewView == paramnca.itemView) {
            b();
          }
        }
        continue;
        localObject2 = null;
      }
      label422:
      localObject1 = localObject2;
      continue;
      label429:
      localObject1 = null;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Int = paramInt;
    b();
    notifyDataSetChanged();
    if (paramBoolean2) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(paramInt);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nby
 * JD-Core Version:    0.7.0.1
 */