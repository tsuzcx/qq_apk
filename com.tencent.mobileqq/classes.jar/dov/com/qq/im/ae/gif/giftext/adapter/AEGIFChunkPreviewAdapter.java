package dov.com.qq.im.ae.gif.giftext.adapter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;
import dov.com.qq.im.ae.gif.giftext.AEGIFPreviewWrapper;
import dov.com.qq.im.ae.gif.giftext.DrawableImageView;
import dov.com.qq.im.ae.gif.giftext.view.AEAnimationDrawable;
import dov.com.qq.im.ae.gif.giftext.viewmodel.AEGIFTextEditViewModel;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.light.device.LightDeviceUtils;

public class AEGIFChunkPreviewAdapter
  extends RecyclerView.Adapter<AEGIFChunkPreviewAdapter.ViewHolder>
{
  private int jdField_a_of_type_Int;
  private LifecycleOwner jdField_a_of_type_AndroidArchLifecycleLifecycleOwner;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private AEGIFChunkPreviewAdapter.OnTextClickListener jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFChunkPreviewAdapter$OnTextClickListener;
  private AEGIFTextEditViewModel jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFTextEditViewModel;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, SoftReference<AEAnimationDrawable>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<AEGIFPreviewWrapper> jdField_a_of_type_JavaUtilList;
  private Set<Integer> jdField_a_of_type_JavaUtilSet;
  
  public AEGIFChunkPreviewAdapter(Context paramContext, List<AEGIFPreviewWrapper> paramList, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Int = ((int)(LightDeviceUtils.getScreenWidth(paramContext) * 0.44F) + 1);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      ((AEGIFPreviewWrapper)this.jdField_a_of_type_JavaUtilList.get(0)).a(true);
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(0));
    }
  }
  
  private void a(ImageView paramImageView, String paramString, int paramInt)
  {
    Object localObject1 = (SoftReference)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localObject1 != null) {}
    for (localObject1 = (AEAnimationDrawable)((SoftReference)localObject1).get();; localObject1 = null)
    {
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        if (!TextUtils.isEmpty(paramString))
        {
          Object localObject2 = new File(paramString);
          if (((File)localObject2).exists())
          {
            localObject2 = ((File)localObject2).listFiles();
            if (localObject2.length > 0)
            {
              int i = 0;
              while (i < localObject2.length)
              {
                String str = String.format(paramString + "/frame_%03d.png", new Object[] { Integer.valueOf(i) });
                if (new File(str).exists()) {
                  ((ArrayList)localObject1).add(str);
                }
                i += 1;
              }
            }
          }
        }
        localObject1 = new AEAnimationDrawable(this.jdField_a_of_type_AndroidContentContext, (ArrayList)localObject1, 55L);
        ((AEAnimationDrawable)localObject1).a(false);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, new SoftReference(localObject1));
      }
      for (paramString = (String)localObject1;; paramString = (String)localObject1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zswp20pro", 2, "playAnimationDrawable, position = " + paramInt);
        }
        if ((paramImageView.getDrawable() != null) && (paramImageView.getDrawable() != paramString) && ((paramImageView.getDrawable() instanceof AEAnimationDrawable)))
        {
          ((AEAnimationDrawable)paramImageView.getDrawable()).stop();
          paramImageView.setImageDrawable(null);
        }
        paramImageView.setImageDrawable(paramString);
        paramString.start();
        return;
      }
    }
  }
  
  private void a(AEGIFOutlineTextView paramAEGIFOutlineTextView)
  {
    if (this.jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFTextEditViewModel != null)
    {
      this.jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFTextEditViewModel.a().observe(this.jdField_a_of_type_AndroidArchLifecycleLifecycleOwner, new AEGIFChunkPreviewAdapter.2(this, paramAEGIFOutlineTextView));
      this.jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFTextEditViewModel.b().observe(this.jdField_a_of_type_AndroidArchLifecycleLifecycleOwner, new AEGIFChunkPreviewAdapter.3(this, paramAEGIFOutlineTextView));
    }
    paramAEGIFOutlineTextView.setOnClickListener(new AEGIFChunkPreviewAdapter.4(this));
    paramAEGIFOutlineTextView.setVisibility(0);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setEnabled(paramBoolean);
      if (paramBoolean) {
        ((TextView)this.jdField_a_of_type_AndroidViewView).setText(HardCodeUtil.a(2131700043));
      }
    }
    else
    {
      return;
    }
    ((TextView)this.jdField_a_of_type_AndroidViewView).setText(HardCodeUtil.a(2131700053));
  }
  
  public AEGIFChunkPreviewAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AEGIFChunkPreviewAdapter.ViewHolder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558612, paramViewGroup, false), this.jdField_a_of_type_JavaLangString);
  }
  
  public Set<Integer> a()
  {
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(AEGIFChunkPreviewAdapter.OnTextClickListener paramOnTextClickListener)
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFChunkPreviewAdapter$OnTextClickListener = paramOnTextClickListener;
  }
  
  public void a(AEGIFChunkPreviewAdapter.ViewHolder paramViewHolder)
  {
    super.onViewRecycled(paramViewHolder);
    if ((AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder) != null) && (AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder).getDrawable() != null) && ((AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder).getDrawable() instanceof AEAnimationDrawable)))
    {
      ((AEAnimationDrawable)AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder).getDrawable()).stop();
      AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder).setImageDrawable(null);
    }
  }
  
  public void a(AEGIFChunkPreviewAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    AEGIFPreviewWrapper localAEGIFPreviewWrapper = (AEGIFPreviewWrapper)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838049);
    localObject = VasApngUtil.getApngURLDrawable("https://qd.myapp.com/myapp/qqteam/QIM/ae_gif_loading.png", new int[] { 0 }, (Drawable)localObject);
    AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder).setImageDrawable((Drawable)localObject);
    AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder).setVisibility(4);
    paramViewHolder.a(localAEGIFPreviewWrapper.a());
    switch (localAEGIFPreviewWrapper.jdField_a_of_type_Int)
    {
    default: 
    case 10: 
    case 11: 
    case 12: 
      for (;;)
      {
        localObject = paramViewHolder.itemView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = -1;
        ((ViewGroup.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
        paramViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramViewHolder.itemView.setOnClickListener(new AEGIFChunkPreviewAdapter.1(this, localAEGIFPreviewWrapper, paramInt, paramViewHolder));
        EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
        return;
        AEGIFChunkPreviewAdapter.ViewHolder.b(paramViewHolder).setVisibility(4);
        AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder).setVisibility(0);
      }
    }
    AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder).setVisibility(8);
    if (paramInt == 0)
    {
      a(AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder));
      AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder).setVisibility(0);
    }
    AEGIFChunkPreviewAdapter.ViewHolder.b(paramViewHolder).setVisibility(0);
    if (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt)))
    {
      paramViewHolder.a(true);
      a(true);
    }
    for (;;)
    {
      localObject = localAEGIFPreviewWrapper.c;
      a(AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder), (String)localObject, paramInt);
      break;
      paramViewHolder.a(false);
    }
  }
  
  public void a(AEGIFTextEditViewModel paramAEGIFTextEditViewModel, LifecycleOwner paramLifecycleOwner)
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFTextEditViewModel = paramAEGIFTextEditViewModel;
    this.jdField_a_of_type_AndroidArchLifecycleLifecycleOwner = paramLifecycleOwner;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter
 * JD-Core Version:    0.7.0.1
 */