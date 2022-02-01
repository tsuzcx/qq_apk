package dov.com.qq.im.ae.gif.giftext;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import dov.com.qq.im.BaseVMPeakActivity;
import dov.com.qq.im.ae.AEViewModelProviders;
import dov.com.qq.im.ae.gif.giftext.adapter.AEGIFSmartTextAdapter;
import dov.com.qq.im.ae.gif.giftext.viewmodel.AEGIFRecommandTextViewModel;
import dov.com.qq.im.lifecycle.GlobalViewModelFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AEGIFTextMvp
  implements AEGIFTextListener
{
  public static final List<String> a;
  private int jdField_a_of_type_Int = 0;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private StaggeredGridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseVMPeakActivity jdField_a_of_type_DovComQqImBaseVMPeakActivity;
  private AEGIFOutlineTextView jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView;
  private AEGIFSmartTextAdapter jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFSmartTextAdapter;
  private AEGIFRecommandTextViewModel jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFRecommandTextViewModel;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaUtilList = Arrays.asList(new String[] { HardCodeUtil.a(2131700058), HardCodeUtil.a(2131700069), HardCodeUtil.a(2131700067), HardCodeUtil.a(2131700074), HardCodeUtil.a(2131700078), HardCodeUtil.a(2131700075), "dbq", "886", HardCodeUtil.a(2131700072), HardCodeUtil.a(2131700071), HardCodeUtil.a(2131700062), "ok", "666", HardCodeUtil.a(2131700064), HardCodeUtil.a(2131700081), HardCodeUtil.a(2131700073) });
  }
  
  public AEGIFTextMvp(BaseVMPeakActivity paramBaseVMPeakActivity, RelativeLayout paramRelativeLayout, AEGIFOutlineTextView paramAEGIFOutlineTextView)
  {
    this.jdField_a_of_type_DovComQqImBaseVMPeakActivity = paramBaseVMPeakActivity;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374471));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378273));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374472));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374468));
    }
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView = paramAEGIFOutlineTextView;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put("happy", HardCodeUtil.a(2131700083));
    this.jdField_a_of_type_JavaUtilHashMap.put("neutral", HardCodeUtil.a(2131700059));
    this.jdField_a_of_type_JavaUtilHashMap.put("sad", HardCodeUtil.a(2131700065));
    this.jdField_a_of_type_JavaUtilHashMap.put("anger", HardCodeUtil.a(2131700076));
    this.jdField_a_of_type_JavaUtilHashMap.put("disgust", HardCodeUtil.a(2131700068));
    this.jdField_a_of_type_JavaUtilHashMap.put("fear", HardCodeUtil.a(2131700063));
  }
  
  private void b(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setText(paramString1);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.getLayoutParams();
    int i;
    if (paramString1.indexOf('\n') > 0)
    {
      i = DisplayUtil.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 73.199997F);
      localLayoutParams.height = i;
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setTextColor(paramString2);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOutlineColor(paramString3);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOutlineWidth(DisplayUtil.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 4.0F));
      if (paramString1.indexOf('\n') <= 0) {
        break label137;
      }
    }
    label137:
    for (float f = DisplayUtil.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 26.0F);; f = DisplayUtil.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 30.0F))
    {
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setTextSize(f);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.invalidate();
      return;
      i = DisplayUtil.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 41.0F);
      break;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFRecommandTextViewModel = ((AEGIFRecommandTextViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, GlobalViewModelFactory.a()).get(AEGIFRecommandTextViewModel.class));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public RecyclerView a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<AEGIFSmartTextData> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new AEGIFSmartTextData((String)localIterator.next()));
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 0);
    this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager.setGapStrategy(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    e();
    c();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if ((!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)) && (this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFSmartTextAdapter != null)) {
      this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFSmartTextAdapter.a();
    }
    b(paramString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840421);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setTextColor(paramString2);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOutlineColor(paramString3);
    a(paramString1);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setStroke(paramBoolean1);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setShadow(paramBoolean2);
  }
  
  public void b()
  {
    Log.d("AEGIFTextMvp", "On loading completed...");
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFSmartTextAdapter = new AEGIFSmartTextAdapter(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, this);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFSmartTextAdapter.setHasStableIds(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFSmartTextAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setClipToPadding(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setClipChildren(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new AEGIFTextMvp.1(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new AEGIFTextMvp.2(this));
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setText(paramString);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOutlineWidth(DisplayUtil.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 4.0F));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.getLayoutParams();
    AEGIFOutlineTextView localAEGIFOutlineTextView = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView;
    float f;
    if (paramString.indexOf('\n') > 0)
    {
      f = DisplayUtil.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 26.0F);
      localAEGIFOutlineTextView.setTextSize(f);
      if (paramString.indexOf('\n') <= 0) {
        break label114;
      }
    }
    label114:
    for (int i = DisplayUtil.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 73.199997F);; i = DisplayUtil.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 41.0F))
    {
      localLayoutParams.height = i;
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setLayoutParams(localLayoutParams);
      return;
      f = DisplayUtil.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 30.0F);
      break;
    }
  }
  
  public void c()
  {
    Log.d("AEGIFTextMvp", "On loading...");
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    d();
    this.jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFRecommandTextViewModel.a().observe(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, new AEGIFTextMvp.3(this));
  }
  
  public void d()
  {
    Log.d("AEGIFTextMvp", "Clearing smart text");
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840422);
    if (this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFSmartTextAdapter != null) {
      this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFSmartTextAdapter.a();
    }
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    a(false, true);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setShadowParam(3.0F, 0.0F, 1.0F, "#73000000");
    b(HardCodeUtil.a(2131700079), "#ccffffff", "#000000");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.AEGIFTextMvp
 * JD-Core Version:    0.7.0.1
 */