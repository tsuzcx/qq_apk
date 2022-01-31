import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.RecommendActivityViewHolder.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class swf
  extends swc
{
  public static final void b(ssm paramssm)
  {
    ThreadManager.post(new RecommendActivityViewHolder.1(paramssm), 8, null, true);
  }
  
  public void a()
  {
    this.itemView.setTag(2131307635, null);
  }
  
  public void a(ssm paramssm)
  {
    super.a(paramssm);
    tfy.b(this.jdField_a_of_type_AndroidWidgetImageView, paramssm.jdField_b_of_type_JavaLangString, true, (int)bacc.a(this.jdField_a_of_type_AndroidWidgetTextView.getContext(), 50.0F));
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    String str;
    int i;
    if (TextUtils.isEmpty(paramssm.c))
    {
      str = ajjy.a(2131647475);
      localTextView.setText(str);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.c.setVisibility(0);
      if (paramssm.jdField_b_of_type_Int <= 0) {
        break label247;
      }
      i = 1;
      label92:
      a(1, i);
      if (QLog.isColorLevel()) {
        QLog.e("zivonchen", 2, "FollowPersonViewHolder userItem = " + paramssm.c + ", faceDrawable = " + paramssm.jdField_b_of_type_JavaLangString);
      }
      str = (String)this.itemView.getTag(2131307635);
      if (!TextUtils.equals(paramssm.jdField_a_of_type_JavaLangString, str)) {
        switch (paramssm.jdField_a_of_type_Int)
        {
        default: 
          str = "unknown";
        }
      }
    }
    for (;;)
    {
      urp.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramssm.jdField_a_of_type_JavaLangString, str });
      this.itemView.setTag(2131307635, paramssm.jdField_a_of_type_JavaLangString);
      return;
      str = paramssm.c;
      break;
      label247:
      i = 0;
      break label92;
      str = "2";
      continue;
      str = "3";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swf
 * JD-Core Version:    0.7.0.1
 */