package com.tencent.mobileqq.mini.ui;

import NS_MINI_FILE_MATERIAL.MiniAppFileMaterial.AppMaterialInfo;
import NS_MINI_FILE_MATERIAL.MiniAppFileMaterial.GetMaterialRelevantAppRsp;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ItemAnimator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.common.ui.LoadingMoreRecyclerAdapter.OnLoadMoreListener;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.server.CommonRequestObserver;
import com.tencent.mobileqq.mini.server.RequestCallback;
import com.tencent.mobileqq.mini.servlet.GetMaterialRelevantAppServlet;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.FileMaterialInfo;
import com.tencent.widget.ActionSheetHelper;
import java.io.File;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/ui/FileMaterialAppListDialog;", "Lcom/tencent/mobileqq/mini/server/RequestCallback;", "LNS_MINI_FILE_MATERIAL/MiniAppFileMaterial$GetMaterialRelevantAppRsp;", "Lcom/tencent/mobileqq/mini/common/ui/LoadingMoreRecyclerAdapter$OnLoadMoreListener;", "mActivity", "Landroid/app/Activity;", "mFile", "Ljava/io/File;", "mMimeType", "", "(Landroid/app/Activity;Ljava/io/File;Ljava/lang/String;)V", "mContentView", "Landroid/view/View;", "mCurExtraInfo", "mDialog", "Landroid/app/Dialog;", "mHasPendingRequest", "", "mListAdapter", "Lcom/tencent/mobileqq/mini/ui/FileMaterialAppListAdapter;", "mRealMimeType", "mTitleTv", "Landroid/widget/TextView;", "buildFileMaterialInfoList", "", "Lcom/tencent/qqmini/sdk/launcher/model/FileMaterialInfo;", "calcRealMimeType", "", "handleItemClicked", "data", "LNS_MINI_FILE_MATERIAL/MiniAppFileMaterial$AppMaterialInfo;", "hide", "initView", "onNeedLoadMore", "onReqFailed", "retCode", "", "errMsg", "onReqSucceed", "rsp", "requestData", "resetContentViewHeight", "show", "Companion", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class FileMaterialAppListDialog
  implements LoadingMoreRecyclerAdapter.OnLoadMoreListener, RequestCallback<MiniAppFileMaterial.GetMaterialRelevantAppRsp>
{
  public static final FileMaterialAppListDialog.Companion Companion = new FileMaterialAppListDialog.Companion(null);
  private static final float MIN_DISPLAY_ITEM_COUNT = 4.5F;
  private static final String TAG = "FileMaterialAppListDialog";
  private final Activity mActivity;
  private final View mContentView;
  private String mCurExtraInfo;
  private final Dialog mDialog;
  private final File mFile;
  private volatile boolean mHasPendingRequest;
  private final FileMaterialAppListAdapter mListAdapter;
  private final String mMimeType;
  private volatile String mRealMimeType;
  private TextView mTitleTv;
  
  public FileMaterialAppListDialog(@NotNull Activity paramActivity, @NotNull File paramFile, @NotNull String paramString)
  {
    this.mActivity = paramActivity;
    this.mFile = paramFile;
    this.mMimeType = paramString;
    this.mListAdapter = new FileMaterialAppListAdapter();
    paramActivity = LayoutInflater.from((Context)this.mActivity).inflate(2030370817, null);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "inflater.inflate(R.layou…al_app_list_dialog, null)");
    this.mContentView = paramActivity;
    paramActivity = ActionSheetHelper.b((Context)this.mActivity, this.mContentView);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "ActionSheetHelper.create…(mActivity, mContentView)");
    this.mDialog = paramActivity;
    initView();
    calcRealMimeType();
  }
  
  private final List<FileMaterialInfo> buildFileMaterialInfoList()
  {
    List localList = Collections.singletonList(new FileMaterialInfo(this.mRealMimeType, this.mFile.getName(), this.mFile.getAbsolutePath(), this.mFile.length()));
    Intrinsics.checkExpressionValueIsNotNull(localList, "Collections.singletonList(item)");
    return localList;
  }
  
  private final void calcRealMimeType()
  {
    if ((Intrinsics.areEqual(this.mMimeType, "image/*") ^ true))
    {
      this.mRealMimeType = this.mMimeType;
      this.mListAdapter.setMimeType(this.mRealMimeType);
      return;
    }
    ThreadManagerV2.executeOnFileThread((Runnable)new FileMaterialAppListDialog.calcRealMimeType.1(this));
  }
  
  private final void handleItemClicked(MiniAppFileMaterial.AppMaterialInfo paramAppMaterialInfo)
  {
    MiniAppLauncher.launchMiniAppByIdWithFile((Context)this.mActivity, paramAppMaterialInfo.appid.get(), paramAppMaterialInfo.path.get(), paramAppMaterialInfo.vt.get(), 1173, buildFileMaterialInfoList());
  }
  
  private final void initView()
  {
    Object localObject = this.mContentView.findViewById(2030305331);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mContentView.findViewById(R.id.tv_list_title)");
    this.mTitleTv = ((TextView)localObject);
    ((ImageView)this.mContentView.findViewById(2030305309)).setOnClickListener((View.OnClickListener)new FileMaterialAppListDialog.initView.1(this));
    localObject = (RecyclerView)this.mContentView.findViewById(2030305328);
    RecyclerView.ItemAnimator localItemAnimator = ((RecyclerView)localObject).getItemAnimator();
    if (localItemAnimator != null) {
      localItemAnimator.setChangeDuration(0L);
    }
    ((RecyclerView)localObject).setAdapter((RecyclerView.Adapter)this.mListAdapter);
    this.mListAdapter.setLoadMoreListener((LoadingMoreRecyclerAdapter.OnLoadMoreListener)this);
  }
  
  private final void requestData()
  {
    Object localObject1 = (CharSequence)this.mRealMimeType;
    int i;
    if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      this.mHasPendingRequest = true;
      return;
    }
    this.mHasPendingRequest = false;
    Object localObject2 = new CommonRequestObserver(MiniAppFileMaterial.GetMaterialRelevantAppRsp.class, (RequestCallback)this);
    localObject1 = new NewIntent((Context)this.mActivity, GetMaterialRelevantAppServlet.class);
    ((NewIntent)localObject1).putExtra("key_mime_type", this.mRealMimeType);
    ((NewIntent)localObject1).putExtra("key_extra_info", this.mCurExtraInfo);
    ((NewIntent)localObject1).setObserver((BusinessObserver)localObject2);
    localObject2 = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplicationImpl.getApplication()");
    ((BaseApplicationImpl)localObject2).getRuntime().startServlet((NewIntent)localObject1);
  }
  
  private final void resetContentViewHeight()
  {
    int i = Companion.getContentViewHeight((Context)this.mActivity, this.mListAdapter.getItemCount());
    View localView = this.mContentView;
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    localLayoutParams.height = i;
    localView.setLayoutParams(localLayoutParams);
  }
  
  public final void hide()
  {
    this.mDialog.dismiss();
  }
  
  public void onNeedLoadMore()
  {
    requestData();
  }
  
  public void onReqFailed(long paramLong, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReqFailed: retCode=");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", errMsg=");
    localStringBuilder.append(paramString);
    QLog.e("FileMaterialAppListDialog", 1, localStringBuilder.toString());
    this.mListAdapter.setLoadingComplete(false, false);
    if (paramLong != 0L) {
      QQToast.makeText((Context)this.mActivity, 1, 2030436353, 0).show();
    }
  }
  
  public void onReqSucceed(@NotNull MiniAppFileMaterial.GetMaterialRelevantAppRsp paramGetMaterialRelevantAppRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramGetMaterialRelevantAppRsp, "rsp");
    this.mCurExtraInfo = paramGetMaterialRelevantAppRsp.extra.get();
    Object localObject = this.mTitleTv;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTitleTv");
    }
    ((TextView)localObject).setText((CharSequence)paramGetMaterialRelevantAppRsp.title.get());
    localObject = this.mListAdapter;
    List localList = paramGetMaterialRelevantAppRsp.relevant_list.get();
    Intrinsics.checkExpressionValueIsNotNull(localList, "rsp.relevant_list.get()");
    ((FileMaterialAppListAdapter)localObject).addData(localList);
    ((FileMaterialAppListAdapter)localObject).setShowLoadingMore(paramGetMaterialRelevantAppRsp.hasMore.get());
    ((FileMaterialAppListAdapter)localObject).setLoadingComplete(true, paramGetMaterialRelevantAppRsp.hasMore.get());
    ((FileMaterialAppListAdapter)localObject).setItemClickListener((FileMaterialAppListAdapter.OnItemClickListener)new FileMaterialAppListDialog.onReqSucceed..inlined.run.lambda.1(this, paramGetMaterialRelevantAppRsp));
    resetContentViewHeight();
  }
  
  public final void show()
  {
    this.mDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.ui.FileMaterialAppListDialog
 * JD-Core Version:    0.7.0.1
 */