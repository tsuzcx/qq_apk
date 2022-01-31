package dov.com.tencent.biz.qqstory.takevideo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import aodz;
import aoea;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.PollWidgetUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.VoteLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.VoteLayer.VoteItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.Publishable;
import dov.com.tencent.biz.qqstory.takevideo.vote.VoteDialog;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EditVideoVote
  extends EditVideoPart
  implements DialogInterface.OnDismissListener, EditVoteExport, Publishable
{
  public static String a;
  private float jdField_a_of_type_Float;
  private EditVideoVote.VoteInfo jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote$VoteInfo;
  private VoteDialog jdField_a_of_type_DovComTencentBizQqstoryTakevideoVoteVoteDialog;
  private float b;
  private float c;
  private float d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "EditVideoVote";
  }
  
  public EditVideoVote(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private JSONObject a(@NonNull EditVideoVote.VoteInfo paramVoteInfo)
  {
    VoteLayer.VoteItem localVoteItem = a().a();
    if (localVoteItem != null)
    {
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("v", 1);
        localJSONObject1.put("id", 1);
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(UIUtils.a(a())), Integer.valueOf(UIUtils.b(a())) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localVoteItem.u * localVoteItem.q), Float.valueOf(localVoteItem.v * localVoteItem.q) }));
        JSONArray localJSONArray3 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localVoteItem.a.x + localVoteItem.s), Float.valueOf(localVoteItem.a.y + localVoteItem.t) }));
        paramVoteInfo = new JSONArray(Arrays.asList(paramVoteInfo.jdField_a_of_type_ArrayOfJavaLangString));
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("ss", localJSONArray1);
        localJSONObject2.put("ls", localJSONArray2);
        localJSONObject2.put("lp", localJSONArray3);
        localJSONObject2.put("r", localVoteItem.r);
        localJSONObject2.put("c", paramVoteInfo);
        localJSONObject1.put("a", localJSONObject2);
        return localJSONObject1;
      }
      catch (JSONException paramVoteInfo)
      {
        SLog.e("Q.qqstory.publish.edit.EditVideoVote", paramVoteInfo.toString());
      }
    }
    return null;
  }
  
  public static void a(Bundle paramBundle, VoteLayer.VoteItem paramVoteItem)
  {
    if (paramVoteItem != null)
    {
      paramBundle.putFloat("scale", paramVoteItem.q);
      paramBundle.putFloat("rotate", paramVoteItem.r);
      paramBundle.putFloat("translateX", paramVoteItem.s);
      paramBundle.putFloat("translateY", paramVoteItem.t);
    }
  }
  
  private void a(EditVideoVote.VoteInfo paramVoteInfo, int paramInt)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoVoteVoteDialog != null) {
      i();
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoVoteVoteDialog = new VoteDialog(a(), this, paramVoteInfo, paramInt);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoVoteVoteDialog.setContentView(2130970920);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoVoteVoteDialog.setOnDismissListener(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoVoteVoteDialog.show();
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoVoteVoteDialog != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoVoteVoteDialog.isShowing()))
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoVoteVoteDialog.dismiss();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoVoteVoteDialog = null;
    }
  }
  
  public Bitmap a()
  {
    VoteLayer localVoteLayer = a();
    if (localVoteLayer.a()) {}
    for (;;)
    {
      return null;
      int i = localVoteLayer.a.width();
      int j = localVoteLayer.a.height();
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        if (localBitmap != null)
        {
          localVoteLayer.d(new Canvas(localBitmap));
          return localBitmap;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        SLog.c("Q.qqstory.publish.edit.EditVideoVote", "OutOfMemoryError :", localOutOfMemoryError);
      }
    }
    return null;
  }
  
  public EditVideoVote.VoteInfo a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote$VoteInfo;
  }
  
  @NonNull
  public VoteLayer a()
  {
    Object localObject = (EditDoodleExport)a(EditDoodleExport.class);
    if (localObject == null) {
      throw new IllegalStateException("can not get EditDoodleExport");
    }
    localObject = ((EditDoodleExport)localObject).a().a();
    if (localObject == null) {
      throw new IllegalStateException("VoteLayer is null.");
    }
    return localObject;
  }
  
  public void a()
  {
    super.a();
    a(EditVoteExport.class, this);
  }
  
  public void a(Bundle paramBundle, String[] paramArrayOfString, Bitmap paramBitmap, Rect[] paramArrayOfRect, boolean paramBoolean)
  {
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Float = paramBundle.getFloat("scale");
      this.b = paramBundle.getFloat("rotate");
      this.c = paramBundle.getFloat("translateX");
      this.d = paramBundle.getFloat("translateY");
    }
    a(paramArrayOfString, paramBitmap, paramArrayOfRect, paramBoolean);
  }
  
  public void a(VoteLayer.VoteItem paramVoteItem, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote$VoteInfo == null)
    {
      SLog.e("Q.qqstory.publish.edit.EditVideoVote", "why vote info is null????");
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(35);
      return;
    }
    Object localObject = new GestureHelper().c(paramVoteItem);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    ((Matrix)localObject).mapPoints(arrayOfFloat);
    paramFloat1 = arrayOfFloat[0];
    paramFloat2 = paramVoteItem.u / 2.0F;
    float f1 = arrayOfFloat[1];
    float f2 = paramVoteItem.v / 2.0F;
    localObject = new Bundle();
    a((Bundle)localObject, paramVoteItem);
    ((Bundle)localObject).putInt("element_index", PollWidgetUtils.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote$VoteInfo.jdField_a_of_type_ArrayOfAndroidGraphicsRect, (int)(paramFloat1 + paramFloat2), (int)(f1 + f2)));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(35, localObject);
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi == null)
    {
      SLog.e("Q.qqstory.publish.edit.EditVideoVote", "set vote info but mUi is null.");
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote$VoteInfo = new EditVideoVote.VoteInfo(paramArrayOfString, paramBitmap, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, this.jdField_a_of_type_Float, this.b, this.c, this.d);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoVoteVoteDialog != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoVoteVoteDialog.isShowing()))
    {
      i();
      return true;
    }
    return false;
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      i();
      return;
    }
    int i = -1;
    paramInt = i;
    if (paramObject != null)
    {
      paramInt = i;
      if ((paramObject instanceof Bundle))
      {
        paramObject = (Bundle)paramObject;
        paramInt = paramObject.getInt("element_index");
        this.jdField_a_of_type_Float = paramObject.getFloat("scale");
        this.b = paramObject.getFloat("rotate");
        this.c = paramObject.getFloat("translateX");
        this.d = paramObject.getFloat("translateY");
      }
    }
    a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote$VoteInfo, paramInt);
    a().c();
    StoryReportor.a("video_edit", "clk_vote_entry", 1, 0, new String[0]);
  }
  
  public void b(int paramInt, GenerateContext paramGenerateContext)
  {
    EditVideoVote.VoteInfo localVoteInfo = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote$VoteInfo;
    if (localVoteInfo != null)
    {
      Object localObject = a(localVoteInfo);
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).toString();
        SLog.a("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, vote json:%s", localObject);
        paramGenerateContext.a.putExtra("pl", localObject);
        paramGenerateContext = new StringBuilder();
        localObject = localVoteInfo.jdField_a_of_type_ArrayOfJavaLangString;
        int i = localObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          paramGenerateContext.append(localObject[paramInt]).append(";");
          paramInt += 1;
        }
        paramGenerateContext.deleteCharAt(paramGenerateContext.length() - 1);
        localObject = paramGenerateContext.toString();
        if (localVoteInfo.jdField_a_of_type_Boolean) {}
        for (paramGenerateContext = "1";; paramGenerateContext = "2")
        {
          StoryReportor.a("video_edit", "pub_vote", 1, 0, new String[] { localObject, paramGenerateContext });
          return;
        }
      }
      SLog.b("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, parse vote json error.");
      return;
    }
    SLog.b("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, vote layer is empty.");
  }
  
  public boolean b()
  {
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote$VoteInfo;
    int i;
    if (localObject != null)
    {
      i = 0;
      if (i >= ((EditVideoVote.VoteInfo)localObject).jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label103;
      }
      if (!TextUtils.isEmpty(localObject.jdField_a_of_type_ArrayOfJavaLangString[i])) {}
    }
    for (;;)
    {
      if (i != -1)
      {
        Context localContext = a();
        if (i == 0) {}
        for (localObject = "还没有输入问题哦";; localObject = "还有未输入的选项哦")
        {
          DialogUtil.a(localContext, 230, (String)localObject, null, "我知道了", "输入", new aodz(this, i), new aoea(this)).show();
          return false;
          i += 1;
          break;
        }
      }
      return true;
      label103:
      i = -1;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote$VoteInfo = null;
    SLog.b("Q.qqstory.publish.edit.EditVideoVote", "deleteVote.");
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoVote
 * JD-Core Version:    0.7.0.1
 */