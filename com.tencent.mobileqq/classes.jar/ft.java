import android.graphics.Rect;
import android.util.SparseArray;
import com.etrump.mixlayout.ETTextView;
import com.tencent.qphone.base.util.QLog;

public class ft
{
  private SparseArray<Rect> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private ETTextView jdField_a_of_type_ComEtrumpMixlayoutETTextView;
  private fn jdField_a_of_type_Fn;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  
  public ft(ETTextView paramETTextView, fn paramfn)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = paramETTextView;
    this.jdField_a_of_type_Fn = paramfn;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    return this.jdField_a_of_type_Fn.a(paramInt1 - this.jdField_a_of_type_ArrayOfInt[0] - this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingLeft(), paramInt2 - this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingTop());
  }
  
  public SparseArray<Rect> a()
  {
    return this.jdField_a_of_type_AndroidUtilSparseArray;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.invalidate();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0)) {}
    fs localfs1;
    fs localfs2;
    do
    {
      return;
      localfs1 = this.jdField_a_of_type_Fn.a(paramInt1);
      localfs2 = this.jdField_a_of_type_Fn.a(paramInt2);
    } while ((localfs1 == null) || (localfs2 == null));
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    Rect localRect1;
    if (localfs1.jdField_a_of_type_Int == localfs2.jdField_a_of_type_Int)
    {
      localRect1 = new Rect();
      if (localfs2.jdField_a_of_type_AndroidGraphicsRect.left >= localfs1.jdField_a_of_type_AndroidGraphicsRect.left) {
        localRect1.set(localfs1.jdField_a_of_type_AndroidGraphicsRect.left, localfs1.jdField_a_of_type_AndroidGraphicsRect.top, localfs2.jdField_a_of_type_AndroidGraphicsRect.right, localfs2.jdField_a_of_type_AndroidGraphicsRect.bottom);
      }
      for (;;)
      {
        localRect1.offset(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingLeft(), this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingTop());
        this.jdField_a_of_type_AndroidUtilSparseArray.append(localfs2.jdField_a_of_type_Int, localRect1);
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.invalidate();
        return;
        localRect1.set(localfs2.jdField_a_of_type_AndroidGraphicsRect.left, localfs2.jdField_a_of_type_AndroidGraphicsRect.top, localfs1.jdField_a_of_type_AndroidGraphicsRect.left, localfs1.jdField_a_of_type_AndroidGraphicsRect.bottom);
      }
    }
    int i = localfs1.jdField_a_of_type_Int;
    int j = localfs2.jdField_a_of_type_Int;
    paramInt2 = j;
    paramInt1 = i;
    if (i > j)
    {
      paramInt1 = localfs2.jdField_a_of_type_Int;
      paramInt2 = localfs1.jdField_a_of_type_Int;
    }
    i = paramInt1;
    label243:
    Rect localRect2;
    if (i <= paramInt2)
    {
      localRect1 = new Rect();
      localRect2 = this.jdField_a_of_type_Fn.a(i);
      if (localRect2 == null)
      {
        QLog.e("ETTextSelection", 1, "no lineBound: " + i + " " + this.jdField_a_of_type_Fn.a() + " " + paramInt1 + " " + paramInt2);
        return;
      }
      if (localfs2.jdField_a_of_type_Int <= localfs1.jdField_a_of_type_Int) {
        break label483;
      }
      if (i != paramInt1) {
        break label416;
      }
      localRect1.set(localfs1.jdField_a_of_type_AndroidGraphicsRect.left, localfs1.jdField_a_of_type_AndroidGraphicsRect.top, localRect2.right, localRect2.bottom);
    }
    for (;;)
    {
      localRect1.offset(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingLeft(), this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingTop());
      this.jdField_a_of_type_AndroidUtilSparseArray.append(i, localRect1);
      i += 1;
      break label243;
      break;
      label416:
      if (i == paramInt2)
      {
        localRect1.set(localRect2.left, localRect2.top, localfs2.jdField_a_of_type_AndroidGraphicsRect.right, localfs2.jdField_a_of_type_AndroidGraphicsRect.bottom);
      }
      else
      {
        localRect1.set(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
        continue;
        label483:
        if (i == paramInt1) {
          localRect1.set(localfs2.jdField_a_of_type_AndroidGraphicsRect.left, localfs2.jdField_a_of_type_AndroidGraphicsRect.top, localRect2.right, localRect2.bottom);
        } else if (i == paramInt2) {
          localRect1.set(localRect2.left, localRect2.top, localfs1.jdField_a_of_type_AndroidGraphicsRect.left, localfs1.jdField_a_of_type_AndroidGraphicsRect.bottom);
        } else {
          localRect1.set(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
        }
      }
    }
  }
  
  public void a(int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i = paramInt;
    if (!paramBoolean) {
      i = paramInt - 1;
    }
    fs localfs = this.jdField_a_of_type_Fn.a(i);
    if (localfs == null) {}
    while ((paramArrayOfInt == null) || (paramArrayOfInt.length < 2)) {
      return;
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLocationInWindow(paramArrayOfInt);
    if (paramBoolean)
    {
      paramArrayOfInt[0] += this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingLeft() + localfs.jdField_a_of_type_AndroidGraphicsRect.left;
      paramInt = paramArrayOfInt[1];
      i = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingTop();
      paramArrayOfInt[1] = (localfs.jdField_a_of_type_AndroidGraphicsRect.bottom + i + paramInt);
      return;
    }
    paramArrayOfInt[0] += this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingLeft() + localfs.jdField_a_of_type_AndroidGraphicsRect.right;
    paramInt = paramArrayOfInt[1];
    i = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingTop();
    paramArrayOfInt[1] = (localfs.jdField_a_of_type_AndroidGraphicsRect.bottom + i + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ft
 * JD-Core Version:    0.7.0.1
 */