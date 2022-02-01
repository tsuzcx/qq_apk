import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;

public class rsn
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private riw jdField_a_of_type_Riw;
  private rjf jdField_a_of_type_Rjf = new rjf();
  private rsg jdField_a_of_type_Rsg = new rsg();
  private rsj jdField_a_of_type_Rsj;
  private rsw jdField_a_of_type_Rsw = new rsw();
  
  public rsn(Activity paramActivity, rsj paramrsj)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Rsj = paramrsj;
    c();
  }
  
  private void a(Bitmap paramBitmap, String paramString)
  {
    paramBitmap = new rsk(paramBitmap, paramString);
    paramBitmap.a(new rsv(this));
    paramBitmap.a();
  }
  
  private void c()
  {
    this.jdField_a_of_type_Rsg.a("暂不支持该类视频格式", new rso(this));
    this.jdField_a_of_type_Rsg.a("视频时长短于5秒，无法上传", new rsp(this));
    this.jdField_a_of_type_Rsg.a("视频文件不存在", new rsq(this));
    String str = "视频大小超过" + sli.b() + "，无法上传";
    this.jdField_a_of_type_Rsg.a(str, new rsr(this));
    this.jdField_a_of_type_Rjf.a(new rss(this));
  }
  
  private void d()
  {
    URL localURL = bgkc.generateAlbumVideoThumbURL(this.jdField_a_of_type_Riw.b, null);
    this.jdField_a_of_type_Riw.e = bdsh.d(localURL.toString());
    if (new File(this.jdField_a_of_type_Riw.e).exists())
    {
      f();
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(localURL, null);
    if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
    {
      a(bgmo.b(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()), this.jdField_a_of_type_Riw.e);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new rsu(this));
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  private void e()
  {
    int j = 0;
    int i;
    if (this.jdField_a_of_type_Riw == null)
    {
      i = 1;
      if (i != 0) {
        i = j;
      }
    }
    for (;;)
    {
      if (i >= this.jdField_a_of_type_Rsj.a()) {
        break label76;
      }
      riw localriw = this.jdField_a_of_type_Rsj.a(i);
      if (this.jdField_a_of_type_Rsg.a(localriw, null))
      {
        this.jdField_a_of_type_Rsj.b(i);
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
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131693999, 1).a();
  }
  
  private void f()
  {
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    EditVideoFragment.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Riw, 10001, localIntent);
  }
  
  private void g()
  {
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "请选择一个视频", 0).a();
  }
  
  public rsw a()
  {
    return this.jdField_a_of_type_Rsw;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rjf.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Rjf.a(paramInt);
  }
  
  public void a(riw paramriw)
  {
    this.jdField_a_of_type_Riw = paramriw;
    this.jdField_a_of_type_Rsw.a(paramriw);
  }
  
  public boolean a(riw paramriw)
  {
    return this.jdField_a_of_type_Rsg.a(paramriw, new rst(this));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Riw == null)
    {
      QLog.e("RIJUGC.SelectVideoPresenter", 1, "saveVideoCoverAndJump failed for selectMediaInfo is null.");
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rsn
 * JD-Core Version:    0.7.0.1
 */