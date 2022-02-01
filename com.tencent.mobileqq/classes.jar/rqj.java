import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;

public class rqj
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private rgo jdField_a_of_type_Rgo;
  private rgx jdField_a_of_type_Rgx = new rgx();
  private rqc jdField_a_of_type_Rqc = new rqc();
  private rqf jdField_a_of_type_Rqf;
  private rqs jdField_a_of_type_Rqs = new rqs();
  
  public rqj(Activity paramActivity, rqf paramrqf)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Rqf = paramrqf;
    c();
  }
  
  private void a(Bitmap paramBitmap, String paramString)
  {
    paramBitmap = new rqg(paramBitmap, paramString);
    paramBitmap.a(new rqr(this));
    paramBitmap.a();
  }
  
  private void c()
  {
    this.jdField_a_of_type_Rqc.a("暂不支持该类视频格式", new rqk(this));
    this.jdField_a_of_type_Rqc.a("视频时长短于5秒，无法上传", new rql(this));
    this.jdField_a_of_type_Rqc.a("视频文件不存在", new rqm(this));
    String str = "视频大小超过" + sjk.b() + "，无法上传";
    this.jdField_a_of_type_Rqc.a(str, new rqn(this));
    this.jdField_a_of_type_Rgx.a(new rqo(this));
  }
  
  private void d()
  {
    URL localURL = AlbumUtil.generateAlbumVideoThumbURL(this.jdField_a_of_type_Rgo.b, null);
    this.jdField_a_of_type_Rgo.e = AbsDownloader.getFilePath(localURL.toString());
    if (new File(this.jdField_a_of_type_Rgo.e).exists())
    {
      f();
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(localURL, null);
    if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
    {
      a(bfvo.b(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()), this.jdField_a_of_type_Rgo.e);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new rqq(this));
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  private void e()
  {
    int j = 0;
    int i;
    if (this.jdField_a_of_type_Rgo == null)
    {
      i = 1;
      if (i != 0) {
        i = j;
      }
    }
    for (;;)
    {
      if (i >= this.jdField_a_of_type_Rqf.a()) {
        break label76;
      }
      rgo localrgo = this.jdField_a_of_type_Rqf.a(i);
      if (this.jdField_a_of_type_Rqc.a(localrgo, null))
      {
        this.jdField_a_of_type_Rqf.b(i);
        return;
        i = 0;
        break;
      }
      i += 1;
    }
    label76:
    if (QLog.isColorLevel()) {
      QLog.d("RIJUGC.SelectVideoPresenter", 2, "not found the select video...");
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694116, 1).a();
  }
  
  private void f()
  {
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    EditVideoFragment.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Rgo, 10001, localIntent);
  }
  
  private void g()
  {
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "请选择一个视频", 0).a();
  }
  
  public rqs a()
  {
    return this.jdField_a_of_type_Rqs;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rgx.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Rgx.a(paramInt);
  }
  
  public void a(rgo paramrgo)
  {
    this.jdField_a_of_type_Rgo = paramrgo;
    this.jdField_a_of_type_Rqs.a(paramrgo);
  }
  
  public boolean a(rgo paramrgo)
  {
    return this.jdField_a_of_type_Rqc.a(paramrgo, new rqp(this));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Rgo == null)
    {
      QLog.e("RIJUGC.SelectVideoPresenter", 1, "saveVideoCoverAndJump failed for selectMediaInfo is null.");
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rqj
 * JD-Core Version:    0.7.0.1
 */