import android.graphics.Rect;
import android.util.SparseArray;
import com.etrump.mixlayout.ETTextView;
import com.tencent.qphone.base.util.QLog;

public class fp
{
  private SparseArray<Rect> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private ETTextView jdField_a_of_type_ComEtrumpMixlayoutETTextView;
  private fj jdField_a_of_type_Fj;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  
  public fp(ETTextView paramETTextView, fj paramfj)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = paramETTextView;
    this.jdField_a_of_type_Fj = paramfj;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    return this.jdField_a_of_type_Fj.a(paramInt1 - this.jdField_a_of_type_ArrayOfInt[0] - this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingLeft(), paramInt2 - this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingTop());
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
    fo localfo1;
    fo localfo2;
    do
    {
      return;
      localfo1 = this.jdField_a_of_type_Fj.a(paramInt1);
      localfo2 = this.jdField_a_of_type_Fj.a(paramInt2);
    } while ((localfo1 == null) || (localfo2 == null));
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    Rect localRect1;
    if (localfo1.jdField_a_of_type_Int == localfo2.jdField_a_of_type_Int)
    {
      localRect1 = new Rect();
      if (localfo2.jdField_a_of_type_AndroidGraphicsRect.left >= localfo1.jdField_a_of_type_AndroidGraphicsRect.left) {
        localRect1.set(localfo1.jdField_a_of_type_AndroidGraphicsRect.left, localfo1.jdField_a_of_type_AndroidGraphicsRect.top, localfo2.jdField_a_of_type_AndroidGraphicsRect.right, localfo2.jdField_a_of_type_AndroidGraphicsRect.bottom);
      }
      for (;;)
      {
        localRect1.offset(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingLeft(), this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingTop());
        this.jdField_a_of_type_AndroidUtilSparseArray.append(localfo2.jdField_a_of_type_Int, localRect1);
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.invalidate();
        return;
        localRect1.set(localfo2.jdField_a_of_type_AndroidGraphicsRect.left, localfo2.jdField_a_of_type_AndroidGraphicsRect.top, localfo1.jdField_a_of_type_AndroidGraphicsRect.left, localfo1.jdField_a_of_type_AndroidGraphicsRect.bottom);
      }
    }
    int i = localfo1.jdField_a_of_type_Int;
    int j = localfo2.jdField_a_of_type_Int;
    paramInt2 = j;
    paramInt1 = i;
    if (i > j)
    {
      paramInt1 = localfo2.jdField_a_of_type_Int;
      paramInt2 = localfo1.jdField_a_of_type_Int;
    }
    i = paramInt1;
    label243:
    Rect localRect2;
    if (i <= paramInt2)
    {
      localRect1 = new Rect();
      localRect2 = this.jdField_a_of_type_Fj.a(i);
      if (localRect2 == null)
      {
        QLog.e("ETTextSelection", 1, "no lineBound: " + i + " " + this.jdField_a_of_type_Fj.a() + " " + paramInt1 + " " + paramInt2);
        return;
      }
      if (localfo2.jdField_a_of_type_Int <= localfo1.jdField_a_of_type_Int) {
        break label483;
      }
      if (i != paramInt1) {
        break label416;
      }
      localRect1.set(localfo1.jdField_a_of_type_AndroidGraphicsRect.left, localfo1.jdField_a_of_type_AndroidGraphicsRect.top, localRect2.right, localRect2.bottom);
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
        localRect1.set(localRect2.left, localRect2.top, localfo2.jdField_a_of_type_AndroidGraphicsRect.right, localfo2.jdField_a_of_type_AndroidGraphicsRect.bottom);
      }
      else
      {
        localRect1.set(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
        continue;
        label483:
        if (i == paramInt1) {
          localRect1.set(localfo2.jdField_a_of_type_AndroidGraphicsRect.left, localfo2.jdField_a_of_type_AndroidGraphicsRect.top, localRect2.right, localRect2.bottom);
        } else if (i == paramInt2) {
          localRect1.set(localRect2.left, localRect2.top, localfo1.jdField_a_of_type_AndroidGraphicsRect.left, localfo1.jdField_a_of_type_AndroidGraphicsRect.bottom);
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
    fo localfo = this.jdField_a_of_type_Fj.a(i);
    if (localfo == null) {}
    while ((paramArrayOfInt == null) || (paramArrayOfInt.length < 2)) {
      return;
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLocationInWindow(paramArrayOfInt);
    if (paramBoolean)
    {
      paramArrayOfInt[0] += this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingLeft() + localfo.jdField_a_of_type_AndroidGraphicsRect.left;
      paramInt = paramArrayOfInt[1];
      i = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingTop();
      paramArrayOfInt[1] = (localfo.jdField_a_of_type_AndroidGraphicsRect.bottom + i + paramInt);
      return;
    }
    paramArrayOfInt[0] += this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingLeft() + localfo.jdField_a_of_type_AndroidGraphicsRect.right;
    paramInt = paramArrayOfInt[1];
    i = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingTop();
    paramArrayOfInt[1] = (localfo.jdField_a_of_type_AndroidGraphicsRect.bottom + i + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     fp
 * JD-Core Version:    0.7.0.1
 */