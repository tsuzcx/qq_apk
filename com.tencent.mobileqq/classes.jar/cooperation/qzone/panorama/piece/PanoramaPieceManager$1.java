package cooperation.qzone.panorama.piece;

class PanoramaPieceManager$1
  implements Runnable
{
  PanoramaPieceManager$1(PanoramaPieceManager paramPanoramaPieceManager) {}
  
  public void run()
  {
    this.this$0.loadOrgPieceData();
    PanoramaPieceManager.access$002(this.this$0, PanoramaPieceManager.ProcessState.DIVIDE_PIECE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.panorama.piece.PanoramaPieceManager.1
 * JD-Core Version:    0.7.0.1
 */