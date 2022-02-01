package com.tencent.mobileqq.wink.editor;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.editor.recommend.WinkRecommendViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class WinkEditorFragment$initRecommendViewModel$1<T>
  implements Observer<List<? extends byte[]>>
{
  WinkEditorFragment$initRecommendViewModel$1(WinkEditorFragment paramWinkEditorFragment) {}
  
  public final void a(List<byte[]> paramList)
  {
    if ((!TextUtils.isEmpty((CharSequence)WinkEditorFragment.n(this.a))) && (!"fakeMid_template_bgm".equals(WinkEditorFragment.n(this.a))))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(WinkEditorFragment.n(this.a));
      WinkEditorMusicHelper.a((ArrayList)localObject, (VSDispatchObserver.onVSRspCallBack)new WinkEditorFragment.initRecommendViewModel.1.1(this, paramList));
      return;
    }
    Object localObject = new ArrayList();
    if ("fakeMid_template_bgm".equals(WinkEditorFragment.n(this.a)))
    {
      ((ArrayList)localObject).add(WinkEditorMusicInfo.l());
      WinkEditorFragment.e(this.a).d().postValue(Boolean.valueOf(true));
    }
    MusicSourceViewModel localMusicSourceViewModel = WinkEditorFragment.e(this.a);
    Intrinsics.checkExpressionValueIsNotNull(paramList, "it");
    localMusicSourceViewModel.a(paramList, (List)localObject);
    paramList = WinkEditorFragment.o(this.a);
    localObject = WinkEditorFragment.p(this.a).b().getValue();
    if (localObject != null)
    {
      paramList.a("MqKuaishanEdit", (ArrayList)localObject, 2);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.ByteArray?> /* = java.util.ArrayList<kotlin.ByteArray?> */");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment.initRecommendViewModel.1
 * JD-Core Version:    0.7.0.1
 */